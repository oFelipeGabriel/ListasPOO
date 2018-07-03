package AtividadeII;

public class oitoCrip {
	int a, b, c, d, y;
	public void criptografar(int x){
		a = (x%10)+7;
		if(a>9) a = a%10;
		y = x/10;
		b = (y%10)+7;
		if(b>9) b = b%10;
		y = y/10;
		c = (y%10)+7;
		if(c>9) c = c%10;
		y = y/10;
		d = y+7;
		if(d>9) d = d%10;
		y=a;
		a=c;
		c=y;
		y=b;
		b=d;
		d=y;
		System.out.println("Criptografados:    d: "+d+" c: "+c+" b: "+b+" a: "+a);
	}
	
	public void descriptografar(){
		y=c;
		c=a;
		a=y;
		y=d;
		d=b;
		b=y;
		a=a-7;
		if(a<0)a=a+10;
		b=b-7;
		if(b<0)b=b+10;
		c=c-7;
		if(c<0)c=c+10;
		d=d-7;
		if(d<0)d=d+10;
		System.out.println("Descriptografados: d: "+d+" c: "+c+" b: "+b+" a: "+a);
		
	}
}
