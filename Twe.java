import java.util.*;
class Twe {
    public static void testDown(Twe twe){
        int[] ref1,ref2,ref3,ref4;
        System.out.println("Testing DOWN");
        System.out.println("1: Simple moves");
        twe.board=new int[][]{{2, 0, 0, 0},
                              {0, 2, 0, 0},
                              {0, 0, 2, 0},
                              {0, 0, 0, 2}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{2,2,2,2};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref1) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref1) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref2) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("2: Simple moves and merges");
        twe.board=new int[][]{{2, 0, 0, 0},
                              {2, 4, 0, 2},
                              {0, 4, 2, 0},
                              {0, 0, 2, 2}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{4,8,4,4};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref1) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref1) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref2) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("3: Simple moves and merges B");
        twe.board=new int[][]{{2, 4, 0, 2},
                              {0, 0, 4, 0},
                              {2, 0, 4, 4},
                              {0, 4, 4, 4}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{0,0,4,2};
        ref3=new int[]{4,8,8,8};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref1) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref2) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref3) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("4: Moves and merges C");
        twe.board=new int[][]{{2, 4, 4, 0},
                              {0, 4, 4, 0},
                              {2, 4, 0, 2},
                              {2, 0, 2, 4}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{2,4,8,2};
        ref3=new int[]{4,8,2,4};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref1) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref2) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref3) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("5: Moves and merges D");
        twe.board=new int[][]{{2, 0, 2, 0},
                              {0, 2, 4, 2},
                              {4, 4, 0, 0},
                              {2, 2, 2, 8}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{2,2,2,0};
        ref3=new int[]{4,4,4,2};
        ref4=new int[]{2,2,2,8};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("6: Moves and merges E");
        twe.board=new int[][]{{2, 2, 4, 4},
                              {2, 4, 4, 8},
                              {8, 4, 2, 2},
                              {2, 2, 2, 2}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{4,2,0,4};
        ref3=new int[]{8,8,8,8};
        ref4=new int[]{2,2,4,4};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("7: Moves A");
        twe.board=new int[][]{{2, 0, 2, 2},
                              {4, 2, 0, 0},
                              {0, 4, 4, 0},
                              {0, 0, 0, 4}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{0,0,0,0};
        ref3=new int[]{2,2,2,2};
        ref4=new int[]{4,4,4,4};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("8: Moves B");
        twe.board=new int[][]{{2, 0, 2, 2},
                              {4, 2, 0, 4},
                              {8, 4, 4, 0},
                              {0, 8, 8, 4}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{2,2,2,0};
        ref3=new int[]{4,4,4,2};
        ref4=new int[]{8,8,8,8};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";

        System.out.println("9: First order merges and moves A");
        twe.board=new int[][]{{2, 2, 2, 2},
                              {2, 0, 2, 4},
                              {4, 2, 0, 0},
                              {0, 4, 4, 4}};
        ref1=new int[]{0,0,0,0};
        ref2=new int[]{0,0,0,0};
        ref3=new int[]{4,4,4,2};
        ref4=new int[]{4,4,4,8};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";

        System.out.println("10: First order merges and moves B");
        twe.board=new int[][]{{2, 2, 2, 2},
                              {2, 4, 4, 2},
                              {2, 8, 2, 4},
                              {2,16, 2, 2}};
        ref1=new int[]{0,2,0,0};
        ref2=new int[]{0,4,2,4};
        ref3=new int[]{4,8,4,4};
        ref4=new int[]{4,16,4,2};
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
        assert twe.fold(true,true)>0 : "Down doesn't move when it should.";

        System.out.println("11: Static test");
        twe.board=new int[][]{{2, 4, 4, 8},
                              {4, 2, 8, 4},
                              {2, 4, 2, 2},
                              {8, 2, 4, 8}};
        ref1=new int[]{2,4,4,8};
        ref2=new int[]{4,2,8,4};
        ref3=new int[]{2,4,2,2};
        ref4=new int[]{8,2,4,8};
        assert twe.fold(true,true)==0 : "Down moves when it shouldn't.";
        assert Arrays.equals(twe.board[0],ref1) : "First row invalid on down.";
        assert Arrays.equals(twe.board[1],ref2) : "Second row invalid on down.";
        assert Arrays.equals(twe.board[2],ref3) : "Third row invalid on down.";
        assert Arrays.equals(twe.board[3],ref4) : "Fourth row invalid on down.";
    }
	public static void main(String[] a){
        // validity tests
        if (a.length > 0) {
            Twe twe = new Twe();
            testDown(twe);
            //testUp(twe);
            //testLeft(twe);
            //testRight(twe);
        }  
		(new Twe()).start();
	}
	int[][] board=new int[4][4];
	void start(){
		int x;
		placeTwo();
		do{
			drawBoard();
			resolve();
			placeTwo();
		}while((x=notDone())>0);
		drawBoard();
		wrapup(x);
	}
	int hasFree(){
		for(int[]y:board)
			for(int x:y)
				if(x<2)return 1;
		return 0;
	}
	int notDone(){
		int moves,x,y;
		for(moves=y=0;y<4;y++){
			for(x=0;x<4;x++){
				if(x<3&&board[y][x]==board[y][x+1]||
					    y<3&&board[y][x]==board[y+1][x])moves++;
				if(board[y][x]>2047)return -1;
			}
		}
		return hasFree()+moves;
	}
	void wrapup(int k){
		if(k<0){
			chalk("you win",true);
		}else{
			chalk("you lose",true);
		}
	}
	void resolve(){
		do{
			switch((new Scanner(System.in)).nextLine().charAt(0)){
				case 'u':
					if (fold(false,true)>0)return;
					break;
				case 'd':
					if (fold(true, true)>0)return;
					break;
				case 'l':
					if (fold(false,false)>0)return;
					break;
				case 'r':
					if (fold(true,false)>0)return;
					break;
				case 'z':
					board[0][0]=2048; // instant win;
					return;
			}
		} while(true);
	}
	// false,true  = up
	// true, true  = down
	// false,false = left
	// true, false = right
	int fold(boolean inv, boolean vert){
		int didMove=0;
		int x,y,q,r,v,n;
		for(int i=0;i<4;i++){
			n=inv?3:0;
			for(int j=1;j<4;){
				v=vert?i:j;
				x=inv?3-v:v;
				v=vert?j:i;
				y=inv?3-v:v;
				q=vert?x:n;
				r=vert?n:y;
				if(board[y][x]==0||n==(vert?y:x))j++;
				else if(board[r][q]==0){
					board[r][q]=board[y][x];
					board[y][x]=0;
					j++;
					didMove++;
				}else if(board[r][q]==board[y][x]){
					board[r][q]*=2;
					board[y][x]=0;
					n+=inv?-1:1;
					didMove++;
					j++;
				}else n+=inv?-1:1;
			}
		}
		return didMove;
	}
	int vec(){
		return (new Random()).nextInt(4);
	}
	void placeTwo(){
		if (hasFree()<1) return;
		int x,y;
		do{
			x=vec();y=vec();
		}while(board[x][y]>0);
		board[x][y]=2;
	}
	void chalk(String a, boolean nl){
		System.out.print(a+(nl?"\n":""));
	}
	String fill(char node, char mid){
		String str = ""+node;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				str+=mid;
			str+=node;
		}
		return str;
	}
	void drawBoard(){
		chalk(fill('+','-'),true);
		String p[] = new String[5];
		for(int[]y:board){
			p[0]=p[1]=p[3]=fill('|',' ');
			p[2]="";
			for(int x=0;x<4;){
				p[2]+=adjust(y[x++]);
			}
			p[2]+="|";
			p[4]=fill('+','-');
			for (String q:p){
				chalk(q,true);
			}
		}
	}
	String adjust(int a){
		return String.format("|%4d",a);
	}
}
