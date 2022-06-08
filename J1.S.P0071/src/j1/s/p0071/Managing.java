package j1.s.p0071;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Managing {

    public Validation val = new Validation();
    ArrayList<Task> tasks;

    public Managing(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int menu() {
        System.out.println("===================Task Program==================");
        System.out.println("1. Add task\n"
                //                + "2. Update\n"
                + "2. Delete task\n"
                + "3. Display task\n"
                + "4. Exit"
        );
        int choice = val.checkInt("Enter your choice: ", 1, 4);
        return choice;
    }

    public void addtask() {
        System.out.println("====================Add Task=========================");
        int id;
        if (tasks.isEmpty()) {
            id = 1;
        } else {
            id = tasks.get(tasks.size() - 1).getId() + 1;
        }
        String name = val.checkInputString("Requement name:");
        int tasktype = val.checkInt("Task type:", 1, 4);
        String date = val.checkDate("Date: ");
        double from;
        double to;
        from = val.checkTime("From: ");
        while (from == 17.5) {
            System.out.println("Can't start at last hours");
            from = val.checkTime("From");
        }
        do {
            to = val.checkTime("To: ");
            if (to < from) {
                System.out.println("From can't after to");
            }

        } while (to < from);
        String assignee = val.checkInputString("Assignee:");
        String reviewer = val.checkInputString("Reviewer:");
        tasks.add(new Task(id, tasktype, name, date, from, to, assignee, reviewer));
        System.out.println("Add Successful!");
    }

//    public void updateTask() {
//        if (tasks.isEmpty()) {
//            System.err.println("List tasks empty!");
//        } else {
//            System.out.println("====================Update Task=========================");
//            int id = val.checkInt("Requirement ID: ", 1, Integer.MAX_VALUE);
//            if (val.isIdExists(tasks, id) == null) {
//                System.err.println("ID Not found! ");
//
//            } else {
//                String name = val.checkInputString("Requement name:");
//                int tasktype = val.checkInt("Task type:", 1, 4);
//                String date = val.checkDate("Date: ");
//                double from;
//                double to;
//                from = val.checkTime("From: ");
//                while (from == 17.5) {
//                    System.err.println("Can't start at last hours");
//                    from = val.checkTime("From: ");
//                }
//                do {
//                    to = val.checkTime("To: ");
//                    if (to < from) {
//                        System.err.println("From can't after to");
//                    }
//
//                } while (to < from);
//                String assignee = val.checkInputString("Assignee:");
//                String reviewer = val.checkInputString("Reviewer:");
//
//                Task task = val.isIdExists(tasks, id);
//                task.setRequirementName(name);
//                task.setTaskTypeId(tasktype);
//                task.setDate(date);
//                task.setPlanFrom(from);
//                task.setPlanTo(to);
//                task.setAssignee(assignee);
//                task.setReviewer(reviewer);
//            }
//            System.out.println("Update Successful!");
//        }
//    }
    public void deleteTask() {
        if (tasks.isEmpty()) {
            System.err.println("Tasks Empty! Can not delete");
        } else {
            System.out.println("=============Del tasks===========");
            int id = val.checkInt("Requirement ID: ", 1, Integer.MAX_VALUE);
            if (val.isIdExists(tasks, id) == null) {
                System.err.println("ID Not found! ");
            } else {
                Task task = val.isIdExists(tasks, id);
                tasks.remove(task);
                System.out.println("Remove success");
            }
        }

    }

    public void getDataTasks() {
        if (tasks.isEmpty()) {
            System.err.println("List Task Empty!");
        } else {
            System.out.println("====================Task=========================");
            System.out.format("%-5s%-15s%-15s%-15s%-10s%-10s%-10s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            String typeName;
            double time;
            Map<Integer, String> name = new HashMap<>();
            name.put(1, "Code");
            name.put(2, "Test");
            name.put(3, "Design");
            name.put(4, "Review");

            for (Task task : tasks) {
                typeName = name.get(task.getTaskTypeId());
                time = task.getPlanTo() - task.getPlanFrom();
                System.out.format("%-5s%-15s%-15s%-15s%-10.1f%-10s%-10s\n",
                        task.getId(), task.getRequirementName(), typeName, task.getDate(),
                        time, task.getAssignee(), task.getReviewer());
            }
        }

    }
}
