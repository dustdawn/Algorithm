package com.dust.mianshi;



/**
 * : 汉诺塔问题
 * @author DUSTDAWN
 *
 */
public class Solution_8 {
	/**
	 * a:起点位
	 * b:辅助位
	 * c:目标位
	 */
	static int count = 0;
	/*
	 * 递归实现
	 */
	public static void Hanoi(int n,char a,char b,char c) {
		if(n==1)
			move(a,c);
		else {
			//第一步:将n-1块看作整体从起点位a，
			//借助辅助位"c",放入终点位b中
			Hanoi(n-1,a,c,b);
			//把1从起点位放入终点位c
			move(a,c);
			//第二步:将n-1块看作整体从起点位b
			//借助辅助位a 放入终点位c中
			Hanoi(n-1,b,a,c);
		}
		
			
	}
	/*
	 * :非递归通过栈实现
	 * 
	 */
	public static void Hanoi2(int n,char a,char b,char c) {
		StateStack stateStack = new StateStack();
		stateStack.push(new State(n,a,b,c));
		State state = null;
		while((state = stateStack.pop())!=null) {
			if(state.N == 1)
				move(state.A,state.C);
			else {
				//逆序,先进后出，后出顺序与递归顺序一致
				stateStack.push(new State(state.N-1,state.B,state.A,state.C));
				stateStack.push(new State(1,state.A,state.B,state.C));
				stateStack.push(new State(state.N-1,state.A,state.C,state.B));
			}
		}
	}
	/**
	 *  :单步移动
	 */
	public static void move(char source, char target) {
		System.out.println(source+"-->"+target);
		count++;
	}
	public static void main(String[] args) {
//		Hanoi(3,'A','B','C');
		Hanoi2(3,'A','B','C');
		System.out.println(count);
	}
}
class State {
	public int N;
	public char A;
	public char B;
	public char C;
	public State(int n, char a, char b, char c) {
		N = n;
		A = a;
		B = b;
		C = c;
	}
}
class StateStack{
	private State[] state = new State[1000];
	private int top = 0;
	public void push(State state) {
		this.state[top++] = state;
	}
	public State pop() {
		if(top>0)
			return state[--top];
		else
			return null;
	}
}
	
	

