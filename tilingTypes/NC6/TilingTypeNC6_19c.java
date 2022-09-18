package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_19c
   extends TilingType
{
   public TilingTypeNC6_19c(){
      super( "NC6-19c", 6, SymmetryType.pgg );

      paramMin = new int[]{ 99};
      paramMax = new int[]{216};
      paramDef = new int[]{130};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {2, 0,5, 1,3,4, 0},
            {2, 4,5, 2,5,4, 0},
            {1, 3,4, 3,0,5, 0},
            {0, 0,1, 4,1,0, 0},

            {0, 4,3, 0,0,5, 1},
            {1, 1,0, 6,0,1, 1},
            {2, 0,5, 7,3,4, 1},
            {2, 4,5, 8,5,4, 1},
            {1, 3,4, 9,0,5, 1},
            {0, 0,1,10,1,0, 1},
      };
      info = "a=b=d=e=f\nA=F\nA+D=360\nD=2E\n(2C+2B+A=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double af = getParam(paramValues, 0);
      double d = 360-af;
      double e = d/2;
      
      double x5 =      ln * Math.cos( af * DEG2RAD );
      double y5 =      ln * Math.sin( af * DEG2RAD );
      double x4 = x5 + ln * Math.cos( (af+af-180) * DEG2RAD );
      double y4 = y5 + ln * Math.sin( (af+af-180) * DEG2RAD );
      double x3 = x4 + ln * Math.cos( (af+af+e) * DEG2RAD );
      double y3 = y4 + ln * Math.sin( (af+af+e) * DEG2RAD );
      double x2 = x3 + ln * Math.cos( (af+af+e-180+d) * DEG2RAD );
      double y2 = y3 + ln * Math.sin( (af+af+e-180+d) * DEG2RAD );

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(4);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(4);
   }
}