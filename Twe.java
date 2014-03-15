import java.util.*;
class Twe {
	public static void main(String[] a){
		(new Twe()).start();
	}
	int[][] board=new int[5][5];
	void start(){
		int x;
		do{
			placeTwo();
			drawBoard();
			resolve();
		}while((x=notDone())>0);
		wrapup(x);
	}
	int notDone(){
		int free=0;
		for(int[]y:board){
			for(int x:y){
				if(x<2)free++;
				if(x>2047)return -1;
			}
		}
		return free;
	}
	void wrapup(int k){
		if(k<0){
			chalk("You win",true);
		}else{
			chalk("You lost",true);
		}
	}
	char getUser(){
		return (new Scanner(System.in)).nextLine().charAt(0);
	}
	void resolve(){
		do{
			switch(getUser()){
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
		return (new Random()).nextInt(5);
	}
	void placeTwo(){
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
		return "|     |     |     |     |     |";
	}
	void drawBoard(){
		chalk("+-----+-----+-----+-----+-----+",true);
		String p[] = new String[6];
		for(int[]y:board){
			p[0]=p[1]=p[3]=p[4]=buffer();
			p[2]="";
			for(int x=0;x<5;){
				p[2]+=adjust(y[x++]);
			}
			p[2]+="|";
			p[5]="+-----+-----+-----+-----+-----+";
			for (String q:p){
				chalk(q,true);
			}
		}
	}
	String adjust(int a){
		return String.format("|%5d",a);
	}
}
