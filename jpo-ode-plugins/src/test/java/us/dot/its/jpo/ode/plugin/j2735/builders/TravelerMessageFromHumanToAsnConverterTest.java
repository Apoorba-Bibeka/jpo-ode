package us.dot.its.jpo.ode.plugin.j2735.builders;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import us.dot.its.jpo.ode.util.JsonUtils;

public class TravelerMessageFromHumanToAsnConverterTest {

   @Test
   public void testRealJson() throws JsonProcessingException, IOException {
      ObjectNode testJson = JsonUtils.toObjectNode(
            "{ \"tim\": { \"index\": \"13\", \"msgCnt\": \"1\", \"timeStamp\": \"2017-08-03T22:25:36.297Z\", \"urlB\": \"null\", \"dataframes\": [ { \"startDateTime\": \"2017-08-02T22:25:00.000Z\", \"durationTime\": 1, \"frameType\": \"1\", \"sspTimRights\": \"0\", \"msgID\": \"RoadSignID\", \"position\": { \"latitude\": \"41.678473\", \"longitude\": \"-108.782775\", \"elevation\": \"917.1432\" }, \"viewAngle\": \"1010101010101010\", \"mutcd\": \"5\", \"crc\": \"0000000000000000\", \"priority\": \"0\", \"sspLocationRights\": \"3\", \"regions\": [ { \"name\": \"Testing TIM\", \"regulatorID\": \"0\", \"segmentID\": \"33\", \"anchorPosition\": { \"latitude\": \"41.2500807\", \"longitude\": \"-111.0093847\", \"elevation\": \"2020.6969900289998\" }, \"laneWidth\": \"7\", \"directionality\": \"3\", \"closedPath\": \"false\", \"description\": \"path\", \"path\": { \"scale\": \"0\", \"type\": \"ll\", \"nodes\": [ { \"nodeLong\": \"0.0031024\", \"nodeLat\": \"0.0014506\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030974\", \"nodeLat\": \"0.0014568\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030983\", \"nodeLat\": \"0.0014559\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030980\", \"nodeLat\": \"0.0014563\", \"delta\": \"node-LL3\" }, { \"nodeLong\": \"0.0030982\", \"nodeLat\": \"0.0014562\", \"delta\": \"node-LL3\" } ] }, \"direction\": \"0000000000001010\" } ], \"sspMsgTypes\": \"2\", \"sspMsgContent\": \"3\", \"content\": \"Advisory\", \"items\": [ \"513\" ], \"url\": \"null\" } ] }, \"rsus\": [ { \"rsuTarget\": \"192.168.1.1\", \"rsuUsername\": \"user\", \"rsuPassword\": \"password\", \"rsuRetries\": \"1\", \"rsuTimeout\": \"2000\" } ], \"snmp\": { \"rsuid\": \"00000083\", \"msgid\": \"31\", \"mode\": \"1\", \"channel\": \"178\", \"interval\": \"2\", \"deliverystart\": \"2017-06-01T17:47:11-05:00\", \"deliverystop\": \"2018-01-01T17:47:11-05:15\", \"enable\": \"1\", \"status\": \"4\" } }");

      JsonNode deTranslatedTim = TravelerMessageFromHumanToAsnConverter.changeTravelerInformationToAsnValues(testJson);

      assertEquals("{\"index\":\"13\",\"msgCnt\":\"1\",\"timeStamp\":23174,\"urlB\":\"null\",\"dataframes\":[{\"startDateTime\":\"2017-08-02T22:25:00.000Z\",\"durationTime\":1,\"frameType\":{\"advisory\":null},\"sspTimRights\":\"0\",\"priority\":\"0\",\"sspLocationRights\":\"3\",\"regions\":[{\"scale\":\"0\",\"offset\":{\"offset\":{\"ll\":[{\"nodeLong\":\"0.0031024\",\"nodeLat\":\"0.0014506\",\"delta\":\"node-LL3\"},{\"nodeLong\":\"0.0030974\",\"nodeLat\":\"0.0014568\",\"delta\":\"node-LL3\"},{\"nodeLong\":\"0.0030983\",\"nodeLat\":\"0.0014559\",\"delta\":\"node-LL3\"},{\"nodeLong\":\"0.0030980\",\"nodeLat\":\"0.0014563\",\"delta\":\"node-LL3\"},{\"nodeLong\":\"0.0030982\",\"nodeLat\":\"0.0014562\",\"delta\":\"node-LL3\"}]}}}],\"sspMsgTypes\":\"2\",\"sspMsgContent\":\"3\",\"content\":{\"advisory\":{\"SEQUENCE\":[{\"text\":513}]}},\"url\":\"null\",\"startYear\":2017,\"startMinute\":21733,\"msgID\":{\"roadSignID\":{\"position\":{\"lat\":410000000,\"long\":-1080000000,\"elevation\":9170},\"viewAngle\":\"1010101010101010\",\"mutcdCode\":\"5\",\"crc\":\"0000000000000000\"}}}]}", deTranslatedTim.toString());
   }

}