import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportedCount = new HashMap<> ();
        Map<String, Set<String>> whoReportedWho = new HashMap<> ();
        
        for(String user : id_list) {
            whoReportedWho.put(user, new HashSet<> ());
        }
        
        for(String rep : report) {
            String[] parts = rep.split(" ");
            String from = parts[0];
            String to = parts[1];
            
            if(!whoReportedWho.get(from).contains(to)) {
                whoReportedWho.get(from).add(to);
                reportedCount.put(to, reportedCount.getOrDefault(to, 0) + 1);
            }
        }
        
        Set<String> bannedUsers = new HashSet<> ();
        for(String user : reportedCount.keySet()) {
            if(reportedCount.get(user) >= k) {
                bannedUsers.add(user);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            String user = id_list[i];
            int mailCount = 0;
            
            for(String reportedUser : whoReportedWho.get(user)) {
                if(bannedUsers.contains(reportedUser)) {
                    mailCount++;
                }
            }
            
            answer[i] = mailCount;
        }
        
        return answer;
    }
}
