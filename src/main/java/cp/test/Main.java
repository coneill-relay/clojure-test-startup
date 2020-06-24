package cp.test;

import com.couchbase.client.java.*;
//import com.couchbase.client.java.env.*;
//import com.couchbase.client.java.document.*;
//import com.couchbase.client.java.document.json.*;
//import com.couchbase.client.java.query.*;

class Simple{  
	public static void main(String args[]){
		long startTime = System.nanoTime();

		//2.0 sdk
		//CouchbaseEnvironment env = DefaultCouchbaseEnvironment
		//.builder()
		//.build();

		//Cluster cluster = CouchbaseCluster.create(env, "localhost");
		//cluster.authenticate("admin", "password");
		//Bucket bucket = cluster.openBucket("relay_data");

		//3.0 sdk
		try {
			Cluster cluster = Cluster.connect("localhost", "admin", "password");
			Bucket bucket = cluster.bucket("relay_data");
		}
		catch (Exception e) {
			System.out.println(e);
		}

		// Other commands
		// Create a JSON Document
		//JsonObject arthur = JsonObject.create()
		//.put("name", "Arthur")
		//.put("email", "kingarthur@couchbase.com")
		//.put("interests", JsonArray.from("Holy Grail", "African Swallows"));

		// Store the Document
		// bucket.upsert(JsonDocument.create("u:king_arthur", arthur));
		// System.out.println(bucket.get("u:king_arthur"));

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " +
				   timeElapsed / 1000000);
	}
}
