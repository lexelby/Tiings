package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_49
   extends TilingType
{
   public TilingTypeNC6_49(){
      super( "NC6-49", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{360,100};
      paramDef = new int[]{125, 75};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 5,0, 1,0,5, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 4,5, 0,2,3, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 5,0, 5,0,5, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=d=f\nc=e\n2A+F=360\nC+D=360\nD=E\n(B+E=A)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.2;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;
      double b = getParam(paramValues, 0);
      
      double diag1 = ln2 - ln1 * Math.cos(b*DEG2RAD);
      double diag2 = calcSide(diag1,ln1/2,b);
      double a2 = calcAngle(ln1/2,diag2,diag1);

      double c1 = ln1 * Math.cos(a2*DEG2RAD);
      double s1 = ln1 * Math.sin(a2*DEG2RAD);
      
      double x5 =      -c1;
      double y5 =      s1;
      double x4 = x5 + c1;
      double y4 = y5 + s1;
      double x3 = x4 + ln2 * Math.cos( (a2-180+b) * DEG2RAD );
      double y3 = y4 + ln2 * Math.sin( (a2-180+b) * DEG2RAD );
      double x2 = x3 + ln1 * Math.cos( (a2+b+b) * DEG2RAD );
      double y2 = y3 + ln1 * Math.sin( (a2+b+b) * DEG2RAD );
      double x1 = x2 + x3-x4;
      double y1 = y2 + y3-y4;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(5);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(3);
   }
}