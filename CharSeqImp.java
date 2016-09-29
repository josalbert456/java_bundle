package org.albert.chars;
import java.util.ArrayList;

public class CharSeqImp implements CharSequence{
	public ArrayList<Character> chars;
	public CharSeqImp(char[] cs){

		chars = new ArrayList<Character>();
		for(char c:cs){
			chars.add(c);
		}
	}
	public CharSequence subSeq(int start, int end)throws OutOfCharBoundException{
		if(end>chars.size()||start>end){
			throw new OutOfCharBoundException();
		}
		
		CharSeqImp csi = new CharSeqImp(new char[]{});

		for(int i=start; i<end; i++){
			csi.addChar(chars.get(i));
		}
		return csi;
	}
	public CharSequence subSequence(int start, int end){
		CharSeqImp csi = new CharSeqImp(new char[]{});
		if(end>chars.size()||start>end){
			return csi;
		}
		for(int i=start; i<end; i++){
			csi.addChar(chars.get(i));
		}
		return csi;
	}
	public void addChar(char c){
		chars.add(c);
	}
	public char charAt(int index){

		return chars.get(index);
	}
	public int length(){
		return chars.size();
	}
}