package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_03b
   extends TilingType
{
   public TilingTypeNC6_03b(){
      super( "NC6-3b", 6, SymmetryType.pg );

      paramMin = new int[]{ 38};
      paramMax = new int[]{144};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,3,4, 1},
            {1, 3,2, 0,0,1, 0},
            {1, 0,1, 2,3,4, 1},
      };
      info = "b=c=d=e=f\nB=C\nC+E=360\n2A+D=360\n(B+F=A)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double e = getParam(paramValues, 0);
      double f = 252;
      double cd = 108;

      double x2 = ln + ln * Math.cos( (180-cd) * DEG2RAD );
      double y2 =      ln * Math.sin( (180-cd) * DEG2RAD );
      double x3 = x2 + ln * Math.cos( (-cd-cd) * DEG2RAD );
      double y3 = y2 + ln * Math.sin( (-cd-cd) * DEG2RAD );
      double x4 = x3 + ln * Math.cos( (-cd-cd+180-e) * DEG2RAD );
      double y4 = y3 + ln * Math.sin( (-cd-cd+180-e) * DEG2RAD );
      double x5 = x4 + ln * Math.cos( (-cd-cd-e-f) * DEG2RAD );
      double y5 = y4 + ln * Math.sin( (-cd-cd-e-f) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(5);
      offsets[2] = tiles[0].getX(3)-tiles[2].getX(5);
      offsets[3] = tiles[0].getY(3)-tiles[2].getY(5);
   }
}