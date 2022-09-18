package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_61
   extends TilingType
{
   public TilingTypeNC6_61(){
      super( "NC6-61", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,270,100};
      paramDef = new int[]{ 50,150, 50};
      paramName = new String[]{"Relative Length", "Angle", "Diagonal length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,0, 0,0,5, 0},
            {1, 3,0, 1,0,3, 0},
            {0, 5,0, 2,0,5, 0},

            {0, 3,5, 0,0,2, 1},
            {1, 5,0, 4,0,5, 1},
            {1, 3,0, 5,0,3, 1},
            {0, 5,0, 6,0,5, 1},
      };
      info = "b=d=e\nc=f\nB+C=360\nC=E\n(A+D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = lntotal - ln1;

      double c = getParam(paramValues, 1);
      double maxDiag = 2*ln2*Math.cos((180-c) * DEG2RAD) + 2*ln1;
      double minDiag = 0;
      if( c>180 ){
         minDiag = -2 * ln1 * Math.sin(c * DEG2RAD);
      }
      double diag = minDiag + ( getParam(paramValues, 2)/100 *(maxDiag-minDiag));
      double diag2 = calcSide(ln1,ln2,c);
      double ang = Math.asin(ln2 * Math.sin(c*DEG2RAD)/diag2)/DEG2RAD;
      double d = calcAngle(diag2,diag2,diag) + 2*ang;

      double x1 = ln1;
      double y1 =   0;
      double x2 = x1 + ln2 * Math.cos( (180+c) * DEG2RAD );
      double y2 = y1 + ln2 * Math.sin( (180+c) * DEG2RAD );
      double x3 = x2 + ln1;
      double y3 = y2;
      double x4 = x3 + ln1 * Math.cos( (180-d) * DEG2RAD );
      double y4 = y3 + ln1 * Math.sin( (180-d) * DEG2RAD );
      double x5 = x4 + ln2 * Math.cos( (-d-c) * DEG2RAD );
      double y5 = y4 + ln2 * Math.sin( (-d-c) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[4].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(0);
   }
}