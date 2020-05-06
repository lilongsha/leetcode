import com.lty.lls.main.Algorithm;
import com.lty.lls.main.ListNode;
import org.junit.jupiter.api.Test;


public class AlogorithmTest {
    @Test
    public void alogorithm01(){
        ListNode listNode1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        System.out.println(listNode1);
        ListNode listNode2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        System.out.println(listNode2);
        long currentTimeMillis = System.currentTimeMillis();
        ListNode resultNode = Algorithm.addTwoNumbers01(listNode1, listNode2, 0);
        System.out.println("------------->耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        System.out.println(resultNode.toString());
    }
}
