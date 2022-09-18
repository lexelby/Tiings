package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_47
   extends TilingType
{
   public TilingTypeNC6_47(){
      super( "NC6-47", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{110, 60};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,4,5, 0},
            {1, 5,4, 1,4,5, 0},
            {0, 4,5, 2,2,1, 0},

            {0, 0,1, 1,0,1, 1},
            {1, 2,1, 4,4,5, 1},
            {1, 5,4, 5,4,5, 1},
            {0, 4,5, 6,2,1, 1},
      };
      info = "a=d=e\nc=f\nC=F\nE+F=360\nB+C=180\n(A+D=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.2;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      double b = getParam(paramValues, 0);

      double diag = calcSide(ln1,2*ln2,180-b);
      double angDAB = Math.asin(Math.sin(b*DEG2RAD)*ln1/diag )/DEG2RAD;
      double angTri = 180-b-angDAB;
      double d = b+angTri - calcAngle(2*ln2,diag,ln1);
         
      double x5 =      ln2 * Math.cos( (180-d) * DEG2RAD );
      double y5 =      ln2 * Math.sin( (180-d) * DEG2RAD );
      double x4 = x5 + ln1 * Math.cos( (180-d-b) * DEG2RAD );
      double y4 = y5 + ln1 * Math.sin( (180-d-b) * DEG2RAD );
      double x3 = x4 + ln2 * Math.cos( (180-d) * DEG2RAD );
      double y3 = y4 + ln2 * Math.sin( (180-d) * DEG2RAD );
      double x2 = x3 + ln2;
      double y2 = y3;
      double x1 = x2 + ln1 * Math.cos( b * DEG2RAD );
      double y1 = y2 - ln1 * Math.sin( b * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[4].getX(3);
      offsets[3] = tiles[3].getY(0)-tiles[4].getY(3);
   }
}