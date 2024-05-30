import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

public class ApplicationTest {

    private static final String te="1";

    @Test
    public void testPassword(){
        //工作因子,默认值为10,最小值为4,最大值为31,值越大运算速度越慢
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //明文: “password”
        //密文: result ,即使明文密码相同,每次生成的密文也不一致(加盐中使用随机数)
        String result = bCryptPasswordEncoder.encode("password");
        System.out.println("result = " + result);
        //密码核验
        Assert.isTrue(bCryptPasswordEncoder.matches("password", result),"密码不一致" );
    }

}
