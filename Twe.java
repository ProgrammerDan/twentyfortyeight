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
					if (fold(false,true)>0)return;
					break;
				case 'd':
					if (foldDown()>0)return;
					break;
				case 'l':
					if (foldLeft()>0)return;
					break;
				case 'r':
					if (foldRight()>0)return;
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
		int nextSpot,x,y,v,q,r;
		int[][] nb = new int[4][4];
		for(int i=0;i<4;i++){
			nextSpot=inv?3:0;
			for(int j=0;j<4;j++){
				v=vert?i:j;
				x=inv?3-v:v;
				v=vert?j:i;
				y=inv?3-v:v;
				q=vert?x:nextSpot;
				r=vert?nextSpot:y;
				if(board[y][x]>0){
					if(nb[r][q]<1){
						nb[r][q]=board[y][x];
						didMove+=(inv?-1:1)*(vert?y-r:x-q);
					}else if(nb[r][q]==board[y][x]){
						nb[r][q]*=2;
						nextSpot+=inv?-1:1;
						didMove++;
					}else{
						nextSpot+=inv?-1:1;//suckage
						q=vert?x:nextSpot;
						r=vert?nextSpot:y;
						nb[r][q]=board[y][x];
						didMove+=(inv?-1:1)*(vert?y-r:x-q);
					}
				}
			}
		}
		board=nb;
		return didMove;
	}


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
		return didMove;
	}
	int foldDown(){
		int didMove=0;
		int nextSpot;
		int[][] nb = new int[4][4];
		for(int x=0;x<4;x++){
			nextSpot=3;
			for(int y=3;y>=0;y--){
				if(board[y][x]>0){
					if(nb[nextSpot][x]<1){
						nb[nextSpot][x]=board[y][x];
						didMove+=nextSpot-y;
					}else if(nb[nextSpot][x]==board[y][x]){
						nb[nextSpot--][x]*=2;
						didMove++;
					}else{
						nb[--nextSpot][x]=board[y][x];
						didMove+=nextSpot-y;
					}
				}
			}
		}
		board=nb;
		return didMove;
	}
	int foldLeft(){
		int didMove=0;
		int nextSpot;
		int[][] nb = new int[4][4];
		for(int x=0;x<4;x++){
			nextSpot=0;
			for(int y=0;y<4;y++){
				if(board[x][y]>0){
					if(nb[x][nextSpot]<1){
						nb[x][nextSpot]=board[x][y];
						didMove+=y-nextSpot;
					}else if(nb[x][nextSpot]==board[x][y]){
						nb[x][nextSpot++]*=2;
						didMove++;
					}else{
						nb[x][++nextSpot]=board[x][y];
						didMove+=y-nextSpot;
					}
				}
			}
		}
		chalk("fold left",true);
		board=nb;
		return didMove;
	}
	int foldRight(){
		int didMove=0;
		int nextSpot;
		int[][] nb = new int[4][4];
		for(int x=0;x<4;x++){
			nextSpot=3;
			for(int y=3;y>=0;y--){
				if(board[x][y]>0){
					if(nb[x][nextSpot]<1){
						nb[x][nextSpot]=board[x][y];
						didMove+=nextSpot-y;
					}else if(nb[x][nextSpot]==board[x][y]){
						nb[x][nextSpot--]*=2;
						didMove++;
					}else{
						nb[x][--nextSpot]=board[x][y];
						didMove+=nextSpot-y;
					}
				}
			}
		}
		chalk("fold right",true);
		board=nb;
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
