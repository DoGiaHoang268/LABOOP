
package j1.s.p0071;

import java.util.ArrayList;

public class J1SP0071 {

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Managing m = new Managing(tasks);
        while (true) {
            switch (m.menu()) {
                case 1:
                    m.addtask();
                    break;
                case 2:
                    m.deleteTask();
                    break;
                case 3:
                    m.getDataTasks();
                    break;
                case 4:
                    return;

                default:
                    return;
            }
        }

    }
}
