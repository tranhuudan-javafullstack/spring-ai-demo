package vn.com.huudan.springai.functioncalling;

import java.util.function.Function;
import vn.com.huudan.springai.functioncalling.StockRetrievalService.Request;
import vn.com.huudan.springai.functioncalling.StockRetrievalService.Response;


public class StockRetrievalService implements Function<Request, Response> {
	
	public record Request(String symbol) {
		
	}
	
	public record Response(Double price) {
		
	}

	@Override
	public Response apply(Request request) {
		return new Response(5000D);
	}

}
