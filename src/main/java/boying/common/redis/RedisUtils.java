package boying.common.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Created by boying on 2017/9/27.
 */
public class RedisUtils {
    private RedisTemplate redisTemplate;

    public void set(String key, Object value, Long milliseconds) {
        // TODO
        final String json;
        if(value == null){
            // TODO
            json = "";
        }else{
            // TODO
            json = "";
        }
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                if(milliseconds == null){
                    connection.set(key.getBytes(), json.getBytes());
                }else {
                    connection.set(key.getBytes(), json.getBytes(), Expiration.milliseconds(milliseconds), null);
                }
                return null;
            }
        });
    }

    public void set(String key, Object value) {
        set(key, value, null);
    }

    public <T> T get(String key, Class<T> clazz) {
        Object obj = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] bytes = connection.get(key.getBytes());
                if (bytes == null || bytes.length == 0) {
                    return null;
                }
                // TODO why warning?
                RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
                return stringSerializer.deserialize(bytes);
            }
        });
        if (obj == null) {
            return null;
        }

        String json = (String)obj;
        // TODO deserialize json
        return null;
    }

}
