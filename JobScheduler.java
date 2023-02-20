import java.util.*;

class Job {
    int start;
    int end;
    int profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class JobScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Jobs:");
        int n = sc.nextInt();

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter job start time, end time, and earnings:");
            int start = sc.nextInt();
            int end = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new Job(start, end, profit));
        }

        // Sort jobs by profit in descending order
        jobs.sort((j1, j2) -> j2.profit - j1.profit);

        // Initialize variables
        int maxProfit = 0;
        int lastEndTime = 0;
        int remainingJobs = 0;
        int remainingProfit = 0;

        // Iterate through the jobs and select the ones with maximum profit
        for (Job job : jobs) {
            if (job.start >= lastEndTime) {
                maxProfit += job.profit;
                lastEndTime = job.end;
            } else {
                remainingJobs++;
                remainingProfit += job.profit;
            }
        }

        // Print the results
        System.out.println("The number of tasks and earnings available for others:");
        System.out.println("Tasks: " + remainingJobs);
        System.out.println("Earnings: " + remainingProfit);
    }
}
