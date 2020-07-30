local current = redis.call('INCR', KEYS[1])
local max = tonumber(ARGV[1])

if current > max
    then redis.call('SET', KEYS[1], 0)
    return 0
else
    return current
end
