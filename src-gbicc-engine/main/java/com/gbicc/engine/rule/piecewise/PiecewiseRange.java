package com.gbicc.engine.rule.piecewise;

import java.util.List;

/**
 * 单值分段函数
 * @author wangshaoping
 *
 */
public class PiecewiseRange extends Piecewise{
	private Range[] ranges;
	
	public PiecewiseRange(List<Range> segments){
		this.ranges =segments.toArray(new Range[]{});
	}
	
	public PiecewiseRange(Range[] ranges){
		this.ranges =ranges;
	}
	
	@Override
	protected String getGroovyScript() {
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<ranges.length;i++){
			if(i==0){
				sb.append("if(");
			}else{
				sb.append("else if(");
			}
			sb.append(parseRangeCondition(ranges[i]));
			sb.append("){").append("\n");
			sb.append("\t" + RESULT_KEY + " =" + ranges[i].getValue()).append(";\n");
			sb.append("}");
		}
		return sb.toString();
	}
	
	private String parseRangeCondition(Range range){
		StringBuilder sb =new StringBuilder();
		String condition =range.getCondition().trim();
		char left =condition.charAt(0);
		char right =condition.charAt(condition.length()-1);
		String mid =condition.substring(1,condition.length()-1);
		String[] split =mid.split(",");
		String leftValue =split[0];
		String rightValue =split[1];
		
		if("-".equals(leftValue)){
			
		}else{
			if('('==left){
				sb.append(INPUT_KEY + ">" + leftValue);
			}else if('['==left){
				sb.append(INPUT_KEY + ">=" + leftValue);
			}
		}
		
		if("-".equals(rightValue)){
			
		}else{
			if(!"-".equals(leftValue)){
				sb.append(" && ");
			}
			if(')'==right){
				sb.append(INPUT_KEY + "<" + rightValue);
			}else if(']'==right){
				sb.append(INPUT_KEY + "<=" + rightValue);
			}
		}
		return sb.toString();
	}
	
	public Range[] getRanges() {
		return ranges;
	}

	public void setRanges(Range[] ranges) {
		this.ranges = ranges;
	}
	
	public static PiecewiseRange getSample(){
		PiecewiseRange result =new PiecewiseRange(
			new Range[]{
				new Range("(-,0]"		,"0.2"),
				new Range("(0,20]"		,"0.2"),
				new Range("(20,40]"		,"0.4"),
				new Range("(40,60]"		,"0.6"),
				new Range("(60,80]"		,"0.8"),
				new Range("(80,100]"	,"1"),
				new Range("(100,-]"		,"1.5")
			}
		);
		return result;
	}
}
