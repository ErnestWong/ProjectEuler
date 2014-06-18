public class Sudoku{
    static int[][] grid = new int[9][9];
    
	static boolean isValid(int row, int col, int sq, int num){
		if(!containsRow(grid[row], num) && !containsCol(col, num) && !containsSq(sq, num)){
			return true;
		}
		else return false;
	}

	static boolean containsRow(int[] row, int n){
		for(int i = 0; i < row.length; i++){
			if(row[i] == n) return true;
		}
		return false;
    }

	static boolean containsCol(int col, int n){
		for(int i = 0; i < 9; i++){
			if(grid[i][col] == n) return true;
		}
		return false;
	}

	static boolean containsSq(int sq, int n){
		int rowinc, colinc;
		switch(sq){	
			case 0: rowinc = 0;
					colinc = 0;
					break;
			case 1: rowinc = 0;
					colinc = 3;
					break;
			case 2: rowinc = 0;
					colinc = 6;
					break;
			case 3: rowinc = 3;
					colinc = 0;
					break;
			case 4: rowinc = 3;
					colinc = 3;
					break;
			case 5: rowinc = 3;
					colinc = 6;
					break;
			case 6: rowinc = 6;
					colinc = 0;
					break;
			case 7: rowinc = 6;
					colinc = 3;
					break;
			case 8: rowinc = 6;
					colinc = 6;
					break;
			default: rowinc = -1;
					 colinc = -1;
					 break;

		}

		for(int i = rowinc; i < rowinc + 3; i++){
			for(int j = colinc; j < colinc + 3; j++){
				if(grid[i][j] == n) return true;
			}
		}
		return false;
	}

	static void display(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void fill(){
		boolean done = false;
		boolean backtrack = false;
		int i = 0;
		int j = 0;
		int c;
		int sq;
		while(!done){

			if(backtrack){
				c = grid[i][j];
				backtrack = false;
			}
			else c = 1;

			if(grid[i][j] <= 0 || backtrack){
				boolean found = false;
				while(!found && c <= 9){
					sq = quadrant(i,j);
					if(isValid(i, j, sq, c)){
						grid[i][j] = c;
						found = true;
					}
					
					else{
						
						c++;
					}
					
				}

				if(!found){
					
					backtrack = true;
					if(j > 0) j--;
					else{
						i--;
						j = 8;
					}
				}
				else{
					if(j == 8){
						i++;
						j = 0;
					}
					else j++;

				}
			}
			
			System.out.println(i + "  " + j);
			display();
			System.out.println();
			if(j == 8 && i == 8) done = true;
		}
       
	}

    static int quadrant(int row, int col){
        if(row < 3){
            if(col < 3) return 0;
            else if(col >= 3 && col < 6) return 1;
            else return 2;
        }
        else if (row >= 3 && row < 6){
            if(col < 3) return 3;
            else if(col >= 3 && col < 6) return 4;
            else return 5;
        }
        else{
            if(col < 3) return 6;
            else if(col >= 3 && col < 6) return 7;
            else return 8;
        }
    }
    
	public static void main(String[] args){
       fill();
	}
}
