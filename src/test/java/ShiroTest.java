import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by ${mfp} on 2018/5/29.
 */
public class ShiroTest {

	public static void main(String[] args) {
		String password = "666";
		String name = "ls";
		Md5Hash md5Hash = new Md5Hash(password,name,1000);
		System.out.println(md5Hash);
		//fba0e6ecc630294326ca8ed34e7f042d  MD5+盐值+次数 ：加密   666+zs+1000
		//fd00b461859cd20bcb4b28263f3c5f98  MD5+盐值+次数 ：加密   666+ls+1000
	}
}
