package boying.service.user;

import boying.common.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by boying on 2017/10/19.
 */
@Service
public class UserSessionService {
    // TODO
    private static final Long sessionExpireMills = 10000L;

    @Autowired
    @Qualifier("userSessionRedisUtils")
    RedisUtils redisUtils;

    // TODO 需要在一个事务里面
    public String createSessionId(Long userId) {
        String newSessionId = UUID.randomUUID().toString();

        String userIdKey = genUerIdKey(userId);
        String oldSessionId = redisUtils.getString(userIdKey);
        if (oldSessionId != null) {
            redisUtils.delete(oldSessionId);
        }

        redisUtils.set(newSessionId, userId.toString());
        redisUtils.set(userIdKey, newSessionId, sessionExpireMills);

        return newSessionId;
    }

    public Long getUserIdBySessionId(String sessionId) {
        return null;
    }

    public void expireSession(String sessionId) {
        redisUtils.delete(sessionId);
    }

    public void expireSession(Long userId) {
    }

    public void keepSession(String sessionId){}

    public static String genUerIdKey(Long userId) {
        return "user_id_" + userId;
    }
}
