package main;
import java.io.IOException;
public class Keyword {
	
	public String name;

	
	public Keyword(String name)
	{
			this.name = name;
	}

	@Override
	public String toString()
	{
		return "[" + name + ","+" ]";// + weight + "]";
	}
}
