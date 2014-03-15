import java.util.*;
class Twe {
	public static void main(String[] a){
		(new Twe()).start();
	}
	int[][] board=new int[4][4];
	void start(){
		int x;
		do{
			placeTwo();
			drawBoard();
			resolve();
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
		int free,moves,x,y;
		for(free=moves=y=0;y<4;y++){
			for(x=0;x<4;x++){
				if(board[y][x]<2)free++;
				else if(x<3&&board[y][x]==board[y][x+1]||
					    y<3&&board[y][x]==board[y+1][x])moves++;
				if(board[y][x]>2047)return -1;
			}
		}
		chalk(""+free+","+moves,true);
		return free+moves;
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
					foldUp();
					return;
				case 'd':
					foldDown();
					return;
				case 'l':
					foldLeft();
					return;
				case 'r':
					foldRight();
					return;
				case 'z':
					board[0][0]=2048; // instant win;
					return;
			}
		} while(true);
	}
	void foldUp(){
		chalk("fold up",true);
	}
	void foldDown(){
		chalk("fold down",true);
	}
	void foldLeft(){
		chalk("fold left",true);
	}
	void foldRight(){
		chalk("fold right",true);
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
	String buffer(){
		return "|     |     |     |     |";
	}
	void drawBoard(){
		chalk("+-----+-----+-----+-----+",true);
		String p[] = new String[6];
		for(int[]y:board){
			p[0]=p[1]=p[3]=p[4]=buffer();
			p[2]="";
			for(int x=0;x<4;){
				p[2]+=adjust(y[x++]);
			}
			p[2]+="|";
			p[5]="+-----+-----+-----+-----+";
			for (String q:p){
				chalk(q,true);
			}
		}
	}
	String adjust(int a){
		return String.format("|%5d",a);
	}
}
