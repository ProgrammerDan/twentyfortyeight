import java.util.*;
class T {
	public static void main(String[] a){
		(new T()).s();
	}
	int[][] b=new int[4][4];
	void s(){
		int x;
		p();
		do{
			d();
			r();
			p();
		}while((x=n())>0);
		d();
		chalk(x<0?"you win":"you lose");
	}
	int h(){
		for(int[]y:b)
			for(int x:y)
				if(x<2)return 1;
		return 0;
	}
	int n(){
		int x,y,i;
		for(y=0;y<4;y++){
			for(x=0;x<4;x++){
				i=b[y][x];
				if(x<3&&i==b[y][x+1]||
					    y<3&&i==b[y+1][x])return 1;
				if(i>2047)return -1;
			}
		}
		return h();
	}
	void r(){
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
					b[0][0]=2048; // instant win;
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
				if(b[y][x]>0){
					if(nb[r][q]<1){
						nb[r][q]=b[y][x];
						didMove+=(inv?-1:1)*(vert?y-r:x-q);
					}else if(nb[r][q]==b[y][x]){
						nb[r][q]*=2;
						nextSpot+=inv?-1:1;
						didMove++;
					}else{
						nextSpot+=inv?-1:1;//suckage
						q=vert?x:nextSpot;
						r=vert?nextSpot:y;
						nb[r][q]=b[y][x];
						didMove+=(inv?-1:1)*(vert?y-r:x-q);
					}
				}
			}
		}
		b=nb;
		return didMove;
	}
	int vec(){
		return (new Random()).nextInt(4);
	}
	void p(){
		if (h()<1) return;
		int x,y;
		do{
			x=vec();y=vec();
		}while(b[x][y]>0);
		b[x][y]=2;
	}
	void chalk(String a){
		System.out.print(a+"\n");
	}
	String fill(char node, char mid){
		String str = ""+node;
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++)
				str+=mid;
			str+=node;
		}
		return str;
	}
	void d(){
		chalk(fill('+','-'));
		String p[] = new String[6];
		for(int[]y:b){
			p[0]=p[1]=p[3]=p[4]=fill('|',' ');
			p[2]="";
			for(int x=0;x<4;){
				p[2]+=adjust(y[x++]);
			}
			p[2]+="|";
			p[5]=fill('+','-');
			for (String q:p){
				chalk(q);
			}
		}
	}
	String adjust(int a){
		return String.format("|%5d",a);
	}
}
