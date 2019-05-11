package com.gbicc.engine.rule.piecewise;

import java.util.List;

public class PiecewiseSegment extends Piecewise{
	private Segment[] segments;
	
	public PiecewiseSegment(List<Segment> segments){
		this.segments =segments.toArray(new Segment[]{});
	}
	
	public PiecewiseSegment(Segment[] segments){
		this.segments =segments;
	}
	
	@Override
	protected String getGroovyScript() {
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<segments.length;i++){
			if(i==0){
				sb.append("if(");
			}else{
				sb.append("else if(");
			}
			sb.append(segments[i].getCondition());
			sb.append("){").append("\n");
			sb.append("\t" + RESULT_KEY + " =" + segments[i].getValue()).append(";\n");
			sb.append("}");
		}
		return sb.toString();
	}
	
	public Segment[] getSegments() {
		return segments;
	}

	public void setSegments(Segment[] segments) {
		this.segments = segments;
	}
	
	public static PiecewiseSegment getSample(){
		PiecewiseSegment result =new PiecewiseSegment(
			new Segment[]{
				new Segment("参数<=0"				,"0.2"),
				new Segment("参数>0 && 参数<=20"		,"0.2"),
				new Segment("参数>20 && 参数<=40"		,"0.4"),
				new Segment("参数>40 && 参数<=60"		,"0.6"),
				new Segment("参数>60 && 参数<=80"		,"0.8"),
				new Segment("参数>80 && 参数<=100"	,"1"),
				new Segment("参数>100 && 参数<=1000"	,"1.5")
			}
		);
		return result;
	}
}
