import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
	public static void main(String[] args) {
		testPool();
	}
	
	public static void testPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);  // 最大连接
		config.setMaxIdle(10);  // 最大空闲
		JedisPool jedisPool = new JedisPool(config, "192.168.0.102", 6379);
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth("mypassword");
			jedis.set("test2", "this is test22");
			String test2 = jedis.get("test2");
			System.out.println(test2);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(jedis != null)
				jedis.close();
			if(jedisPool != null)
				jedisPool.close();
		}
	
		
		
	}
	
}
