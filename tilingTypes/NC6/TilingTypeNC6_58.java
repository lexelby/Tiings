package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_58
   extends TilingType
{
   public TilingTypeNC6_58(){
      super( "NC6-58", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,360,100};
      paramDef = new int[]{ 70,150, 30};
      paramName = new String[]{"Relative Length", "Angle", "Relative Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,0, 0,0,5, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 5,0, 2,0,5, 0},

            {0, 2,3, 2,0,1, 1},
            {1, 5,0, 4,0,5, 1},
            {1, 4,1, 5,1,4, 1},
            {0, 5,0, 6,0,5, 1},
      };
      info = "b=d\nc=e=f\nC+D=360\nB+D+E=360\n(A+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = lntotal - ln1;

      double e = getParam(paramValues, 1);
      double c = e * getParam(paramValues, 2)/100;
      double f = e - c;
      
      double x1 = ln1;
      double y1 =   0;
      double x2 = x1 + ln2 * Math.cos( (180-f) * DEG2RAD );
      double y2 = y1 + ln2 * Math.sin( (180-f) * DEG2RAD );
      double x3 = x2 + ln1 * Math.cos( (-f-e) * DEG2RAD );
      double y3 = y2 + ln1 * Math.sin( (-f-e) * DEG2RAD );
      double x4 = x3 + ln2 * Math.cos( (180-f) * DEG2RAD );
      double y4 = y3 + ln2 * Math.sin( (180-f) * DEG2RAD );
      double x5 = x4 + ln2 * Math.cos( (-f-c) * DEG2RAD );
      double y5 = y4 + ln2 * Math.sin( (-f-c) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(0)-tiles[3].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[7].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[7].getY(4);
   }
}