package com.rarestzhou.codewars.october;

/**
 * All rights Reserved, Designed By rarestzhou@gmail.com
 *
 * @author: wuxiu
 * @date: 2022/10/9 3:50 PM
 * @description: Codewars style ranking system:
 *  https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java
 */
public class User {

    private static final int PROGRESS_HUNDRED = 100;

    /**
     * rank of user
     */
    protected int rank;

    /**
     * progress while user completes activities
     */
    protected int progress;

    public User() {
        // initial value is -8
        this.rank = -8;
        this.progress = 0;
    }

    /**
     * increment the progress
     *
     * @param rank  the rank of an activity
     */
    protected void incProgress(int rank) {
        // check rank value range
        if (rank < -8 || rank == 0 || rank > 8) {
            throw new IllegalArgumentException("Invalid rank value!");
        }

        // if value of gap is positive, which means user's rank is lower than activities,
        // otherwise, higher
        int gap = rank - this.rank;
        if (rank > 0 && this.rank < 0) {
            // ignore 0
            gap = gap - 1;
        }
        // progress: rankGap * gap * gap
        if (gap <= -2) {
            System.out.println("Any activities completed that are ranking 2 levels or more lower " +
                    "than the user's ranking will be ignored");
            return;
        }

        if (gap == -1) {
            System.out.println("Completing an activity that is ranked one ranking lower than the " +
                    "user's will be worth 1 point");
            this.progress += 1;
            handleUserRank(this.progress);
            return;
        }

        if (gap == 0) {
            System.out.println("Completing an activity that is ranked the same as that of the " +
                    "user's will be worth 3 points");
            this.progress += 3;
            handleUserRank(this.progress);
            return;
        }

        this.progress += 10 * gap * gap;
        this.progress = handleUserRank(this.progress);
    }

    private int handleUserRank(int progress) {
        int acquiredRanks = progress / PROGRESS_HUNDRED;
        int remainProgress = progress % PROGRESS_HUNDRED;

        int newRank = this.rank + acquiredRanks;
        if (newRank > 8) {
            throw new IllegalArgumentException("The highest rank is 8");
        }
        if (this.rank < 0 && newRank >= 0) {
            this.rank = newRank + 1;
        } else {
            this.rank = newRank;
        }
        return this.rank == 8 ? 0 : remainProgress;
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println("rank:" + user.rank + ",progress:" + user.progress);
        user.incProgress(-1);
        System.out.println("After applying rank of -1 the progress was expected to be 21");
        System.out.println("rank:" + user.rank + ",progress:" + user.progress);

    }
}
