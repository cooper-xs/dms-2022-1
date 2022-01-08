import com.dms.DmsUtils.TranMD5;
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
        System.out.println(biz.selectStudentByDorm("11", "518"));
    }
}
