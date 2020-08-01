package org.example.tinurl.backend.integration;

import org.example.tinurl.backend.*;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.MatchesPattern.matchesPattern;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTest extends IntegrationTestBase {

    @Test
    void shouldReturnAllowedCharactersForShortLink() throws ExecutionException, InterruptedException {
        Map<String, String> originalToShortLink = generateOriginalToShortLinks(1000, "https://bash.im/");
        Pattern pattern = Pattern.compile("([A-Z]|[a-z]|[0-9]|[_]){10}");
        for (String shortLink: originalToShortLink.values()) {
            assertThat(shortLink, matchesPattern(pattern));
        }
    }

    @Test
    void shouldReturnUniqueShortLinks() throws ExecutionException, InterruptedException {
        assertThat(generateOriginalToShortLinks(
                1000, "https://shouldReturnUniqueShortLinks/").size(),
                equalTo(1000));
    }

    @Test
    void shouldUniqueShortLinksToUniqueOriginal() throws ExecutionException, InterruptedException {
        Map<String, String> originalToShortLinks = generateOriginalToShortLinks(
                1000,
                "https://shouldUniqueShortLinksToUniqueOriginal/");

        for (Map.Entry<String, String> originalToShort : originalToShortLinks.entrySet()) {
            GetMiniRequest miniRequest = GetMiniRequest.newBuilder().setOriginalUrl(originalToShort.getKey()).build();
            assertThat(tinyUrlServiceFutureStub.getMini(miniRequest).get().getMinifiedUrl(), equalTo(originalToShort.getValue()));
        }
    }

    @Test
    void shouldReturnOriginalBySortLink() throws ExecutionException, InterruptedException {
        Map<String, String> originalToShortLinks = generateOriginalToShortLinks(
                1000,
                "https://shouldReturnOriginalBySortLink/");

        for (Map.Entry<String, String> originalToShort : originalToShortLinks.entrySet()) {
            GetMaxiRequest maxiRequest = GetMaxiRequest.newBuilder().setMinifiedUrl(originalToShort.getValue()).build();
            assertThat(tinyUrlServiceFutureStub.getMaxi(maxiRequest).get().getOriginalUrl(), equalTo(originalToShort.getKey()));
        }
    }

    private Map<String, String> generateOriginalToShortLinks(int number, String baseUrl) throws ExecutionException, InterruptedException {
        HashMap<String, String> originalToShortLinks = new HashMap<>(number);
        for (int i = 0; i < number; i++) {
            String originalLink = baseUrl + i;
            GetMiniRequest miniRequest = GetMiniRequest.newBuilder().setOriginalUrl(originalLink).build();
            originalToShortLinks.put(originalLink, tinyUrlServiceFutureStub.getMini(miniRequest).get().getMinifiedUrl());
        }
        return originalToShortLinks;
    }

}
