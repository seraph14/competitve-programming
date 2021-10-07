/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Stack<Integer> stack = new Stack<>();
        stack.push(id);
        int currentId;
        int sum = 0;
        
        while (!stack.isEmpty()) {
            currentId = stack.pop();
            for (Employee employee : employees) {
                if (employee.id == currentId) {
                    sum += employee.importance;
                    for (int ids : employee.subordinates)
                        stack.push(ids);
                }
            }
        }
        
        return sum;
    }
}
