package cp.test;

import com.couchbase.client.java.*;
import com.couchbase.client.java.env.*;
import com.couchbase.client.java.document.*;
import com.couchbase.client.java.document.json.*;
import com.couchbase.client.java.query.*;

class Simple{  
	public static void main(String args[]){
		long startTime = System.nanoTime();

		CouchbaseEnvironment env = DefaultCouchbaseEnvironment
			.builder()
			.build();

		Cluster cluster = CouchbaseCluster.create(env, "localhost");
		cluster.authenticate("admin", "password");
		Bucket bucket = cluster.openBucket("relay_data");

		// Create a JSON Document
		JsonObject arthur = JsonObject.create()
			.put("name", "Arthur")
			.put("email", "kingarthur@couchbase.com")
			.put("interests", JsonArray.from("Holy Grail", "African Swallows"));

		// Store the Document
		bucket.upsert(JsonDocument.create("u:king_arthur", arthur));
		System.out.println(bucket.get("u:king_arthur"));

		long endTime = System.nanoTime();
		// get difference of two nanoTime values
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds  : " + timeElapsed);
		System.out.println("Execution time in milliseconds : " +
				   timeElapsed / 1000000);
		// Initialize the Connection
	}
}
