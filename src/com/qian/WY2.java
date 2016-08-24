package com.qian;

import java.util.Scanner;
public class WY2 {
	

	public static boolean isOk(boolean[][] isPut,int x,int y) {
		int a = isPut.length;//asdfasdasd
		int b = isPut[0].length;
		
		for (int i = 0; i < a; i++) {
			if(isPut[i][y])
				if(x - i == 2 || x - i == -2 )
					return false;
		}
		for (int i = 0; i < b; i++) {
			if(isPut[x][i])
				if(y - i == 2 || y - i == -2 )
					return false;
		}
		
		/*for (int m = 0; m < a; m++) {
			for (int n = 0; n < b; n++) {
				//判断距离是否是2
				if(isPut[m][n])
					if((x - m) * (x - m) + (y - n) * (y - n) == 4)
						return false;
			}
			
		}*/
		return true;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            int grid[][] = new int[a][b];
            boolean isPut[][] = new boolean[a][b];
            int sum = 0;
            for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					/*if(i == 0 && j == 0) 
						System.out.println(isOk(isPut,i,j));*/
					if(isOk(isPut,i,j)) {
						sum ++;
						isPut[i][j] = true;
					//	System.out.println("i" + i + "j" + j + ":" + sum);
					}
					
				}
			}
            //Math.abs(asd);
            System.out.println(sum);
        }
    }
}
