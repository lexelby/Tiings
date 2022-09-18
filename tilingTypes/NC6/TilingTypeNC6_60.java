package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_60
   extends TilingType
{
   public TilingTypeNC6_60(){
      super( "NC6-60", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,360,100};
      paramDef = new int[]{ 70,150, 50};
      paramName = new String[]{"Relative Length", "Angle", "Relative Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,0, 0,0,5, 0},
            {1, 5,4, 1,4,5, 0},
            {0, 5,0, 2,0,5, 0},

            {0, 1,2, 1,0,1, 1},
            {1, 5,0, 4,0,5, 1},
            {1, 5,4, 5,4,5, 1},
            {0, 5,0, 6,0,5, 1},
      };
      info = "b=c=e\nd=f\nC+E=360\nB+C+D=360\n(A+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = lntotal - ln1;

      double f = getParam(paramValues, 1);
      double c = f * getParam(paramValues, 2)/100;
      
      double x1 = ln1;
      double y1 =   0;
      double x2 = x1 + ln1 * Math.cos( (180-c) * DEG2RAD );
      double y2 = y1 + ln1 * Math.sin( (180-c) * DEG2RAD );
      double x3 = x2 + ln2 * Math.cos( (-c+f) * DEG2RAD );
      double y3 = y2 + ln2 * Math.sin( (-c+f) * DEG2RAD );
      double x4 = x3 - ln1;
      double y4 = y3;
      double x5 = x4 + ln2 * Math.cos( -f * DEG2RAD );
      double y5 = y4 + ln2 * Math.sin( -f * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(3)-tiles[1].getX(1);
      offsets[1] = tiles[7].getY(3)-tiles[1].getY(1);
      offsets[2] = tiles[4].getX(3)-tiles[2].getX(1);
      offsets[3] = tiles[4].getY(3)-tiles[2].getY(1);
   }
}