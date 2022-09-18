package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_255
   extends TilingType
{
   public TilingTypeNC5_255(){
      super( "NC5-255", 5, SymmetryType.pgg );

      paramMin = new int[]{0};
      paramMax = new int[]{100};
      paramDef = new int[]{50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,1, 0,0,1, 0},
            {1, 0,1, 1,1,0, 0},
            {1, 0,2, 2,2,0, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 0,1, 4,2,1, 0},
            
            {2, 1,0, 0,0,4, 1},
            {0, 2,1, 6,0,1, 1},
            {1, 0,1, 7,1,0, 1},
            {1, 0,2, 8,2,0, 1},
            {0, 1,0, 9,0,1, 1},
            {2, 0,1,10,2,1, 1},
      };
      info = "a=d=e\nb=2c+d\nC=E\nD+E=360\n(A+B+C=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln1 = .5;
      double ln2 = ln1 * getParam(paramValues,0)/100;
      double ln3 = 3*ln1+2*ln2;
      double a = calcAngle(2*ln1, ln3, 2*ln1+ln2);
      double e = calcAngle(2*ln1, 2*ln1+ln2, ln3);
      
      double x4 = ln1*Math.cos( a * DEG2RAD);
      double y4 = ln1*Math.sin( a * DEG2RAD);
      double x3 = x4 + ln1*Math.cos( (a+e-180) * DEG2RAD);
      double y3 = y4 + ln1*Math.sin( (a+e-180) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln3, 0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[11].getX(1);
      offsets[1] = tiles[5].getY(0)-tiles[11].getY(1);
      offsets[2] = tiles[6].getX(4)-tiles[4].getX(0);
      offsets[3] = tiles[6].getY(4)-tiles[4].getY(0);
   }

}
