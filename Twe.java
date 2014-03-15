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
					if (foldUp()>0)return;
					break;
				case 'd':
					if (foldDown()>0)return;
					break;
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
	// x x x 2 = 2 x x x
	// x x 2 x = 2 x x x
	// x 2 x x = 2 x x x
	// 2 x x x = 2 x x x
	// x x 2 2 = 4 x x x
	// x 2 2 x = 4 x x x
	// 2 2 x x = 4 x x x
	// x 2 x 2 = 4 x x x
	// 2 x 2 x = 4 x x x
	// 2 x x 2 = 4 x x x
	// 2 x 2 2 = 2 4 x x
	// 2 2 x 2 = 4 2 x x
	// 2 2 2 2 = 4 4 x x
	// 4 2 2 x = 4 4 x x
	// 4 4 4 x = 8 4 x x
	// 2 x 4 x = 2 4 x x
	// x x 2 4 = 2 4 x x
	int foldUp(){
		int didMove=0;
		int nextSpot;
		int[][] nb = new int[4][4];
		for(int x=0;x<4;x++){
			nextSpot=0;
			for(int y=0;y<4;y++){
				if(board[y][x]>0){
					if(nb[nextSpot][x]<1){
						nb[nextSpot][x]=board[y][x];
						didMove+=y-nextSpot;
					}else if(nb[nextSpot][x]==board[y][x]){
						nb[nextSpot++][x]*=2;
						didMove++;
					}else{
						nb[++nextSpot][x]=board[y][x];
						didMove+=y-nextSpot;
					}
				}
			}
		}
		board=nb;
		chalk("fold up",true);
		return didMove;
	}
	int foldDown(){
		int didMove=0;
		int[][] nb = new int[4][4];
		for(int x=0;x<4;x++){
			int freeSpace=-1;
			int lastSpace=-1;
			for(int y=0;y<4;y++){
				if (board[3-y][x]>0){
					if (lastSpace>-1&&nb[3-lastSpace][x]==board[3-y][x]){
						nb[3-lastSpace][x]*=2;
						lastSpace=-1;
						didMove++;
						if (freeSpace<0||freeSpace>-1&&y<freeSpace)
							freeSpace=y;
					}else if(freeSpace>-1){
						nb[3-freeSpace][x]=board[3-y][x];
						lastSpace=freeSpace;
						freeSpace=y;
						didMove++;
					}else{
						nb[3-y][x]=board[3-y][x];
						lastSpace=y;
						freeSpace=-1;
					}
				} else {
					if (freeSpace<0||freeSpace>-1&&y<freeSpace)
						freeSpace=y;
				}
			}
		}
		board=nb;
		chalk("fold down",true);
		return didMove;
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
