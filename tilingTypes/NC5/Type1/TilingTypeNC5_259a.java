package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_259a
   extends TilingType
{
   public TilingTypeNC5_259a(){
      super( "NC5-259a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {2, 1,0, 1,3,4, 0},
            {1, 2,3, 0,3,2, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 1,0, 4,3,4, 0},
      };
      info = "a=c=d\nb=2a\nB=C\nC=E\nD+E=360\n(A+B+C=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln1 = 0.5;
      double f = getParam(paramValues,0)/100;
      double ln2 = ln1 * f;
      
      double a = calcAngle(ln1*2, ln1*2, ln1+ln2);
      double b = 90-a/2;
      
      double x4 = ln1*Math.cos(a*DEG2RAD);
      double y4 = ln1*Math.sin(a*DEG2RAD);
      double x2 = ln1*2 + ln1*Math.cos((180-b)*DEG2RAD);
      double y2 =         ln1*Math.sin((180-b)*DEG2RAD);
      double x3 = x2 - x4;
      double y3 = y2 - y4;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1*2, 0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[2].getX(0);
      offsets[1] = tiles[5].getY(2)-tiles[2].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(4);
   }

}
