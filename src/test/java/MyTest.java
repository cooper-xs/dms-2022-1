import com.dms.DmsUtils.TranMD5;
import com.dms.DmsUtils.DateUtil;
import com.dms.Ex.PasswordNotSameException;
import com.dms.Ex.PasswordSameWithBeforeException;
import com.dms.Ex.PasswordWrongException;
import com.dms.Po.Manager;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import org.junit.Test;

public class MyTest {
    @Test
    public void TestMD5() {
        System.out.println(TranMD5.md5("admin"));
    }

    @Test
    public void TestSelectStudentByDorm() {
        Biz biz = new BizImpl();
        System.out.println(biz.selectStudentByBuilding_idAndDorm_id("11", "518"));
    }

    @Test
    public void TestResetPassword() {
        Biz biz = new BizImpl();
        try {
            System.out.println(biz.resetPassword("1", "1", "c4ca4238a0b923820dcc509a6f75849b", "c4ca4238a0b923820dcc509a6f75849b"));
        } catch (PasswordWrongException e) {
            System.out.println("密码错误");
        } catch (PasswordNotSameException e) {
            System.out.println("重复输入密码不同");
        } catch (PasswordSameWithBeforeException e) {
            System.out.println("与之前的密码相同");
        }
    }

    @Test
    public void TestUpdateManager() {
        Biz biz = new BizImpl();
        System.out.println(biz.updateManagerInfo("2", new Manager("333", "2", "123123")));
    }

    @Test
    public void TestSecTime() {
        System.out.println(DateUtil.stringToLong("2022-01-11 09:45:15"));
    }
}
