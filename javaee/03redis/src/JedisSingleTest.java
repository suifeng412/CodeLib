import redis.clients.jedis.Jedis;

public class JedisSingleTest {
	public static void main(String[] args) {
		testSingle();
	}
	
	public static void testSingle() {
		Jedis jedis = new Jedis("192.168.0.102", 6379);
		jedis.auth("mypassword");
		jedis.set("test1", "this is test");
		String test1 = jedis.get("test1");
		System.out.println(test1);
		jedis.close();
	}
}
