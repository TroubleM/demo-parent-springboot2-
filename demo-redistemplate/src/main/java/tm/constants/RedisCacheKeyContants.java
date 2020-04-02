package tm.constants;

/**
 * @auther: zhangyi
 * @date: 2019/12/13
 * @Description: redis缓存的key/key前缀-常量
 */
public class RedisCacheKeyContants {

    /**
     * @auther: zhangyi
     * @date: 2019/10/1
     * @Description: 登录验证码缓存key前缀
     */
    public static final String LOGIN_CODE_CACHE_KEY_PREFIX = "loginCodeCacheKey:";

    /**
     * @auther: zhangyi
     * @date: 2019/11/19
     * @Description: 推送记录的缓存Hash-Key
     */
    public static final String PUSH_RECORD_CACHE_HASH_KEY = "pushRecordCache";

    /**
     * @auther: zhangyi
     * @date: 2019/9/20
     * @Description: 用户登录的缓存key前缀
     */
    public static final String USER_LOGIN_CACHE_KEY_PREFIX = "userLoginCacheKey:";

    /**
     * @auther: zhangyi
     * @date: 2019/9/20
     * @Description: 用户小程序登录的缓存key前缀
     */
    public static final String USER_MINI_LOGIN_CACHE_KEY_PREFIX = "userMiniLoginCacheKey:";

    /**
     * @auther: zhangyi
     * @date: 2019/11/12
     * @Description: 用户登录的token集合缓存Hash-Key
     */
    public static final String USER_LOGIN_TOKEN_CACHE_KEY = "userLoginTokenCache";

    /**
     * @auther: zhangyi
     * @date: 2019/11/12
     * @Description: 用户小程序登录的token集合缓存Hash-Key
     */
    public static final String USER_MINI_LOGIN_TOKEN_CACHE_KEY = "userMiniLoginTokenCache";

    /**
     * @auther: zhangyi
     * @date: 2019/11/11
     * @Description: 新建后密码为初始密码的用户缓存Hash-Key
     */
    public static final String DEFAULT_PASSWORD_USER_CACHE_KEY = "defaultPasswordUserCache";

    /**
     * @auther: zhangyi
     * @date: 2019/11/11
     * @Description: 用户输入密码错误的缓存次数前缀
     */
    public static final String PASSWORD_ERROR_COUNT_CACHE_PREFIX = "passwordErrorCountCacheKey:";

    /**
     * @auther: zhangyi
     * @date: 2019/11/11
     * @Description: 用户连续输入密码错误3次的缓存key前缀
     */
    public static final String PASSWORD_LOCK_CACHE_KEY_PREFIX = "passwordLockCacheKey:";

    /**
     * @auther: zhangyi
     * @date: 2019/12/18
     * @Description: 找回密码手机验证码缓存key前缀
     */
    public static final String PASSWORD_BACK_CACHE_KEY_PREFIX = "passwordBackCacheKeyPrefix:";

    /**
     * @auther: zhangyi
     * @date: 2019/12/18
     * @Description: 小程序找回密码手机验证码缓存key前缀
     */
    public static final String MINI_PASSWORD_BACK_CACHE_KEY_PREFIX = "miniPasswordBackCacheKeyPrefix:";

    /**
     * @auther: zhangyi
     * @date: 2019/12/24
     * @Description: 强制挤下线的用户标识缓存Hash-Key前缀
     */
    public static final String FORCE_LOGOFF_CACHE_KEY_PREFIX = "forceLogoffCacheKeyPrefix:";

    /**
     * @auther: zhangyi
     * @date: 2019/12/24
     * @Description: 强制挤下线的用户标识缓存Hash-Key前缀
     */
    public static final String FORCE_MINI_LOGOFF_CACHE_KEY_PREFIX = "forceMiniLogoffCacheKeyPrefix:";

    /**
     * @auther: zhangyi
     * @date: 2019/12/3
     * @Description: 字典Hash结构缓存key
     */
    public static final String DICTIONARY_CACHE_KEY = "dictionaryCacheKey";

    /**
     * 库存锁定key
     */
    public static final String INVENTORY_LOCK = "loginCodeCacheKey:";

    /**
     * 库存锁定过期时间
     */
    public static final long EXPIRATION_TIME = 1000*60*60*24L;

    /**
     * @auther: zhangyi
     * @date: 2020/2/28
     * @Description: 京东到家缓存对象key
     */
    public static final String JDDJ_AUTH_TOKEN_CACHE_KEY = "jddjAuthTokenCacheKey";

}
