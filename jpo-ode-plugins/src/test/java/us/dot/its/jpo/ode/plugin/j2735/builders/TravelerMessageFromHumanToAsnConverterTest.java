package us.dot.its.jpo.ode.plugin.j2735.builders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import us.dot.its.jpo.ode.util.JsonUtils;
import us.dot.its.jpo.ode.util.JsonUtils.JsonUtilsException;

public class TravelerMessageFromHumanToAsnConverterTest {

   @Test
   public void testNodeLL() throws JsonProcessingException, IOException, JsonUtilsException {
      ObjectNode testJson = JsonUtils.toObjectNode(
            "{ \"tim\": { \"index\": \"13\", \"packetID\": \"2\", \"msgCnt\": \"1\", \"timeStamp\": \"2017-12-01T17:47:11-05:00\", \"urlB\": \"null\", \"dataframes\": [ { \"startDateTime\": \"2017-08-02T22:25:00.000Z\", \"durationTime\": 1, \"frameType\": \"1\", \"sspTimRights\": \"0\", \"msgId\": \"roadSignID\", \"position\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"viewAngle\": \"1010101010101010\", \"mutcd\": \"5\", \"crc\": \"0000000000000000\", \"priority\": \"0\", \"sspLocationRights\": \"3\", \"regions\": [ { \"name\": \"Testing TIM\", \"regulatorID\": \"0\", \"segmentID\": \"33\", \"anchorPosition\": { \"latitude\": \"41.2500807\", \"longitude\": \"-111.0093847\", \"elevation\": \"2020.6969900289998\" }, \"laneWidth\": \"7\", \"directionality\": \"3\", \"closedPath\": \"false\", \"description\": \"path\", \"path\": { \"scale\": \"0\", \"type\": \"ll\", \"nodes\": [ { \"nodeLong\": \"0.0031024\", \"nodeLat\": \"0.0014506\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030974\", \"nodeLat\": \"0.0014568\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030983\", \"nodeLat\": \"0.0014559\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030980\", \"nodeLat\": \"0.0014563\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030982\", \"nodeLat\": \"0.0014562\", \"delta\": \"node-LL3\" } ] }, \"direction\": \"0000000000001010\" } ], \"sspMsgTypes\": \"2\", \"sspMsgContent\": \"3\", \"content\": \"Advisory\", \"items\": [ \"513\", \"515\" ], \"url\": \"null\" } ] }, \"rsus\": [ { \"rsuTarget\": \"192.168.1.1\", \"rsuUsername\": \"user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"1\", \"rsuTimeout\": \"2000\" } ], \"snmp\": { \"rsuid\": \"00000083\", \"msgid\": \"31\", \"mode\": \"1\", \"channel\": \"178\", \"interval\": \"2\", \"deliverystart\": \"2017-06-01T17:47:11-05:00\", \"deliverystop\": \"2018-01-01T17:47:11-05:15\", \"enable\": \"1\", \"status\": \"4\" } }");

      JsonNode deTranslatedTim = TravelerMessageFromHumanToAsnConverter.changeTravelerInformationToAsnValues(testJson);

      assertEquals(testJson.toString(), deTranslatedTim.toString());
      JSONObject timObject = new JSONObject();
      timObject.put("TravelerInformation", JsonUtils.toJSONObject(deTranslatedTim.toString()));
      assertNotNull(XML.toString(timObject));
      // assertEquals("string", XML.toString(timObject));
   }

   @Test
   public void testNodeXY() throws JsonUtilsException {
      ObjectNode testJson = JsonUtils.toObjectNode(
            "{\"tim\":{\"msgCnt\":\"1\",\"index\":\"3\",\"timeStamp\":\"2017-10-27T18:04:43.045Z\",\"packetID\":\"3\",\"urlB\":\"null\",\"dataframes\":[{\"startDateTime\":\"2017-10-20T05:22:33.985Z\",\"durationTime\":100,\"frameType\":\"1\",\"sspTimRights\":\"1\",\"msgId\":\"roadSignID\",\"position\":{\"latitude\":\"40.573068\",\"longitude\":\"-105.049016\",\"elevation\":\"1500.8999999999999\"},\"viewAngle\":\"1111111111111111\",\"mutcd\":\"2\",\"crc\":\"0000000000000000\",\"priority\":\"5\",\"sspLocationRights\":\"1\",\"regions\":[{\"name\":\"Testing TIM\",\"regulatorID\":\"0\",\"segmentID\":\"33\",\"anchorPosition\":{\"latitude\":\"40.573068\",\"longitude\":\"-105.049016\",\"elevation\":\"1500.8999999999999\"},\"laneWidth\":\"327\",\"directionality\":\"3\",\"closedPath\":\"false\",\"description\":\"path\",\"path\":{\"scale\":\"0\",\"type\":\"xy\",\"nodes\":[{\"nodeLong\":\"-105.047355\",\"nodeLat\":\"40.572429\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.046844\",\"nodeLat\":\"40.572228\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.04659\",\"nodeLat\":\"40.572113\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.046243\",\"nodeLat\":\"40.57191\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.045936\",\"nodeLat\":\"40.571675\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.045674\",\"nodeLat\":\"40.571422\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.04545\",\"nodeLat\":\"40.571131\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.045235\",\"nodeLat\":\"40.570724\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.045113\",\"nodeLat\":\"40.570293\",\"delta\":\"node-LatLon\"},{\"nodeLong\":\"-105.045087\",\"nodeLat\":\"40.569848\",\"delta\":\"node-LatLon\"}]},\"direction\":\"1111111111111111\"}],\"sspMsgTypes\":\"1\",\"sspMsgContent\":\"1\",\"content\":\"Advisory\",\"items\":[\"7425\"],\"url\":\"null\"}]},\"rsus\":[{\"rsuRetries\":\"3\",\"rsuTimeout\":\"5000\",\"rsuUsername\":\"v3user\",\"rsuPassword\":\"password\",\"rsuTarget\":\"192.168.0.145\",\"indicies\":[1,2]}],\"snmp\":{\"rsuid\":\"00000083\",\"msgid\":\"31\",\"mode\":\"1\",\"channel\":\"178\",\"interval\":\"2\",\"deliverystart\":\"2017-06-01T17:47:11-05:00\",\"deliverystop\":\"2018-01-01T17:47:11-05:15\",\"enable\":\"1\",\"status\":\"4\"},\"sdw\":{\"ttl\":\"oneday\",\"serviceRegion\":{\"nwCorner\":{\"latitude\":\"45.035685245316394\",\"longitude\":\"-110.95195770263672\"},\"seCorner\":{\"latitude\":\"40.96538194577477\",\"longitude\":\"-104.15382385253906\"}}}}");
      JsonNode deTranslatedTim = TravelerMessageFromHumanToAsnConverter.changeTravelerInformationToAsnValues(testJson);

      assertEquals(testJson.toString(), deTranslatedTim.toString());
      JSONObject timObject = new JSONObject();
      timObject.put("TravelerInformation", JsonUtils.toJSONObject(deTranslatedTim.toString()));
      assertNotNull(XML.toString(timObject));
   }

   @Test
   public void testGeometry() throws JsonUtilsException {
      ObjectNode testJson = JsonUtils.toObjectNode(
            "{ \"ode\": { \"version\": 2, \"index\":10 }, \"tim\": { \"index\": \"10\", \"msgCnt\": \"13\", \"timeStamp\": \"2017-03-13T01:07:11-05:00\", \"packetID\": \"1\", \"urlB\": \"null\", \"dataframes\": [ { \"sspTimRights\": \"0\", \"frameType\": \"0\", \"msgId\": \"roadSignID\", \"position\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"viewAngle\": \"1010101010101010\", \"mutcd\": \"5\", \"crc\": \"0000000000000000\", \"startDateTime\": \"2017-12-01T17:47:11-05:00\", \"durationTime\": \"22\", \"priority\": \"0\", \"sspLocationRights\": \"3\", \"regions\": [ { \"name\": \"bob\", \"regulatorID\": \"23\", \"segmentID\": \"33\", \"anchorPosition\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"laneWidth\": \"7\", \"directionality\": \"3\", \"closedPath\": \"false\", \"direction\": \"1010101010101010\", \"description\": \"geometry\", \"geometry\": { \"direction\": \"1010101010101010\", \"extent\": \"1\", \"laneWidth\": \"33\", \"circle\": { \"position\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"radius\": \"15\", \"units\": \"7\" } } } ], \"sspMsgTypes\": \"2\", \"sspMsgContent\": \"3\", \"content\": \"Advisory\", \"items\": [ \"250\" ], \"url\": \"null\" } ] }, \"rsus\": [ { \"rsuTarget\": \"127.0.0.1\", \"rsuUsername\": \"v3user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"0\", \"rsuTimeout\": \"2000\" },{ \"rsuTarget\": \"127.0.0.2\", \"rsuUsername\": \"v3user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"1\", \"rsuTimeout\": \"1000\" },{ \"rsuTarget\": \"127.0.0.3\", \"rsuUsername\": \"v3user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"1\", \"rsuTimeout\": \"1000\" } ], \"snmp\": { \"rsuid\": \"0083\", \"msgid\": \"31\", \"mode\": \"1\", \"channel\": \"178\", \"interval\": \"1\", \"deliverystart\": \"2017-12-01T17:47:11-05:00\", \"deliverystop\": \"2018-12-01T17:47:11-05:15\", \"enable\": \"1\", \"status\": \"4\" }, \"sdw\": { \"ttl\": \"oneweek\", \"serviceRegion\": { \"nwCorner\": { \"latitude\": \"44.998459\", \"longitude\": \"-111.040817\" }, \"seCorner\": { \"latitude\": \"41.104674\", \"longitude\": \"-104.111312\" } } } }");
      JsonNode deTranslatedTim = TravelerMessageFromHumanToAsnConverter.changeTravelerInformationToAsnValues(testJson);

      assertEquals(testJson.toString(), deTranslatedTim.toString());
      JSONObject timObject = new JSONObject();
      timObject.put("TravelerInformation", JsonUtils.toJSONObject(deTranslatedTim.toString()));
      assertNotNull(XML.toString(timObject));
   }

   @Test
   public void testRoadSignID() throws JsonUtilsException {
      ObjectNode testJson = JsonUtils.toObjectNode(
            "{ \"ode\": { \"version\": 2, \"index\": \"53\" }, \"tim\": { \"index\": \"54\", \"msgCnt\": \"2\", \"timeStamp\": \"2017-08-03T22:25:36.297Z\", \"urlB\": \"null\", \"packetID\": \"EC9C236B0000000000\", \"dataframes\": [ { \"startDateTime\": \"2017-08-02T22:25:00.000Z\", \"durationTime\": 1, \"sspTimRights\": \"0\", \"frameType\": \"advisory\", \"msgId\": { \"roadSignID\": { \"position\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"viewAngle\": \"1010101010101010\", \"mutcdCode\": \"warning\", \"crc\": \"0000000000000000\" } }, \"priority\": \"0\", \"sspLocationRights\": \"3\", \"regions\": [ { \"name\": \"Testing TIM\", \"regulatorID\": \"0\", \"segmentID\": \"33\", \"anchorPosition\": { \"latitude\": \"41.2500807\", \"longitude\": \"-111.0093847\", \"elevation\": \"2020.6969900289998\" }, \"laneWidth\": \"7\", \"directionality\": \"3\", \"closedPath\": \"false\", \"description\": \"path\", \"path\": { \"scale\": \"0\", \"type\": \"ll\", \"nodes\": [ { \"nodeLong\": \"0.0031024\", \"nodeLat\": \"0.0014506\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030974\", \"nodeLat\": \"0.0014568\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030983\", \"nodeLat\": \"0.0014559\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030980\", \"nodeLat\": \"0.0014563\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030982\", \"nodeLat\": \"0.0014562\", \"delta\": \"node-LL3\" } ] }, \"direction\": \"0000000000001010\" } ], \"sspMsgTypes\": \"2\", \"sspMsgContent\": \"3\", \"content\": \"Advisory\", \"items\": [ \"513\" ], \"url\": \"null\" } ] }, \"rsus\": [ { \"rsuTarget\": \"192.168.1.1\", \"rsuUsername\": \"v3user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"2\", \"rsuTimeout\": \"5000\", \"indicies\": [ 5 ] } ], \"snmp\": { \"rsuid\": \"00000083\", \"msgid\": \"31\", \"mode\": \"1\", \"channel\": \"178\", \"interval\": \"2\", \"deliverystart\": \"2017-06-01T17:47:11-05:00\", \"deliverystop\": \"2018-02-02T17:47:11-05:15\", \"enable\": \"1\", \"status\": \"4\" } } ");
      JsonNode deTranslatedTim = TravelerMessageFromHumanToAsnConverter.changeTravelerInformationToAsnValues(testJson);

      assertEquals(testJson.toString(), deTranslatedTim.toString());
      JSONObject timObject = new JSONObject();
      timObject.put("TravelerInformation", JsonUtils.toJSONObject(deTranslatedTim.toString()));
      assertNotNull(XML.toString(timObject));
   }

   @Test
   public void testPathTim() throws JsonUtilsException {
      ObjectNode testJson = JsonUtils.toObjectNode(
            "{ \"ode\": { \"version\": 2 }, \"tim\": { \"index\": \"13\", \"msgCnt\": \"1\", \"timeStamp\": \"2017-08-03T22:25:36.297Z\", \"urlB\": \"null\", \"packetID\": \"EC9C236B0000000000\", \"dataframes\": [ { \"startDateTime\": \"2017-08-02T22:25:00.000Z\", \"durationTime\": 1, \"sspTimRights\": \"0\", \"frameType\": \"advisory\", \"msgId\": { \"roadSignID\": { \"position\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"viewAngle\": \"1010101010101010\", \"mutcdCode\": \"warning\", \"crc\": \"0000000000000000\" } }, \"priority\": \"0\", \"sspLocationRights\": \"3\", \"regions\": [ { \"name\": \"Testing TIM\", \"regulatorID\": \"0\", \"segmentID\": \"33\", \"anchorPosition\": { \"latitude\": \"41.2500807\", \"longitude\": \"-111.0093847\", \"elevation\": \"2020.6969900289998\" }, \"laneWidth\": \"7\", \"directionality\": \"3\", \"closedPath\": \"false\", \"description\": \"path\", \"path\": { \"scale\": \"0\", \"type\": \"ll\", \"nodes\": [ { \"nodeLong\": \"0.0031024\", \"nodeLat\": \"0.0014506\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030974\", \"nodeLat\": \"0.0014568\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030983\", \"nodeLat\": \"0.0014559\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030980\", \"nodeLat\": \"0.0014563\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030982\", \"nodeLat\": \"0.0014562\", \"delta\": \"node-LL3\" } ] }, \"direction\": \"0000000000001010\" } ], \"sspMsgTypes\": \"2\", \"sspMsgContent\": \"3\", \"content\": \"Advisory\", \"items\": [ \"513\" ], \"url\": \"null\" } ] }, \"rsus\": [ { \"rsuTarget\": \"127.0.0.1\", \"rsuUsername\": \"user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"1\", \"rsuTimeout\": \"2000\" } ], \"snmp\": { \"rsuid\": \"00000083\", \"msgid\": \"31\", \"mode\": \"1\", \"channel\": \"178\", \"interval\": \"2\", \"deliverystart\": \"2017-06-01T17:47:11-05:00\", \"deliverystop\": \"2018-01-01T17:47:11-05:15\", \"enable\": \"1\", \"status\": \"4\" }, \"sdw\": { \"ttl\": \"oneminute\", \"serviceRegion\": { \"nwCorner\": { \"latitude\": \"44.998459\", \"longitude\": \"-111.040817\" }, \"seCorner\": { \"latitude\": \"41.104674\", \"longitude\": \"-104.111312\" } } } } ");
      JsonNode deTranslatedTim = TravelerMessageFromHumanToAsnConverter.changeTravelerInformationToAsnValues(testJson);

      assertEquals(testJson.toString(), deTranslatedTim.toString());
      JSONObject timObject = new JSONObject();
      timObject.put("TravelerInformation", JsonUtils.toJSONObject(deTranslatedTim.toString()));
      assertNotNull(XML.toString(timObject));
   }

}
