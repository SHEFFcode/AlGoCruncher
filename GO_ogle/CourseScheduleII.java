class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return null;
        int[] order = new int[numCourses];
        int[] numPRsForCourse = new int[numCourses];
        int L = prerequisites.length;
        int orderIndex = 0;
        //count how many pre
        for (int[] preRequisiteListAtIndex : prerequisites) {
            numPRsForCourse[preRequisiteListAtIndex[0]]++;
        }
        Queue<Integer> coursesTaken = new LinkedList<>();//store taken classes
        for(int i = 0; i < numCourses; i++){
            if(numPRsForCourse[i] == 0){
                coursesTaken.offer(i);//take the class
                order[orderIndex] = i;//put into class list
                orderIndex++;
            }
        }
        while (!coursesTaken.isEmpty()) {
            int pre = coursesTaken.poll();
            for (int[] preRequisiteListAtIndex : prerequisites) {
                if (pre == preRequisiteListAtIndex[1]) {
                    numPRsForCourse[preRequisiteListAtIndex[0]]--;
                    if (numPRsForCourse[preRequisiteListAtIndex[0]] == 0) {//there can be more than one prereq;
                        if (orderIndex < numCourses) order[orderIndex] = preRequisiteListAtIndex[0];
                        orderIndex++;
                        coursesTaken.offer(preRequisiteListAtIndex[0]);
                    }
                }
            }
        }

        return (orderIndex == numCourses) ? order : new int[0];
    }
}
