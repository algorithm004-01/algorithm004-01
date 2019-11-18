/**
 * TemplateOfRecursion 没什么可说是，就是机械式的记忆下来！！！
 */
public class TemplateOfRecursion {
    public void recur(int level, int param) {
        
        //terminator
        if (level > MAX_LEVEL) {
            //process result
            return;
        }

        //process current logic
        process(level, param);

        //drill down
        recur(level + 1, newParam);

        //restore current status
        
    }
}