package core;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * This class will handle the call from the client to the central server and will send the answer.
 */
@Path("/resource/rest/{fenNotation}")
public class CentralServerResource {
	protected static final String NO_RESULT = "NULL";
	protected CentralServer server = new CentralServer();
	
	@GET
	@Produces("text/plain")
	public String getBestMove(@PathParam("fenNotation")String fen) throws UnsupportedEncodingException {
		String move = this.server.getBestMove(fen);
		if(move==null) {
			return NO_RESULT;
		} else {
			return move;
		}
	}
}