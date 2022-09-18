package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_29
   extends TilingType
{
   public TilingTypeNC6_29(){
      super( "NC6-29", 6, SymmetryType.pgg );

      paramMin = new int[]{ 43};
      paramMax = new int[]{120};
      paramDef = new int[]{105};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,5, 0,5,0, 0},
            {1, 0,1, 2,0,1, 1},

            {0, 2,1, 1,4,5, 1},
            {1, 0,1, 4,0,1, 0},
            {0, 0,5, 4,5,0, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "a=c=d=e=f\nC+E=360\nC+2D=360\n2A+F=360\n(B+D=A)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double c = getParam(paramValues, 0);
      double diag1 = calcSide(ln,ln,c);
      double b = 2*c;
      double d = 360-b;
      double angCDB = calcAngle(diag1,ln,ln);
      double diag2 = calcSide(diag1, ln, d-angCDB);
      double angDBE = calcAngle(diag1,diag2,ln);
      double angABE = b - calcAngle(ln,diag1,ln) + (c>60 ? -angDBE : angDBE);
      double ext = calcSide(2*ln, diag2, angABE);
      double a = 2 * calcAngle(2*ln, ext, diag2);
      double f = 180-a/2;

      double x5 =      ln * Math.cos( f * DEG2RAD );
      double y5 =      ln * Math.sin( f * DEG2RAD );
      double x4 = x5 + ln * Math.cos( (f-180+a) * DEG2RAD );
      double y4 = y5 + ln * Math.sin( (f-180+a) * DEG2RAD );
      double x3 = x4 + ln * Math.cos( (f+a+b) * DEG2RAD );
      double y3 = y4 + ln * Math.sin( (f+a+b) * DEG2RAD );
      double x2 = x3 + ln * Math.cos( (f+a+b-180+c) * DEG2RAD );
      double y2 = y3 + ln * Math.sin( (f+a+b-180+c) * DEG2RAD );
      double x1 = x2 + ln * Math.cos( (f+a+b+c+d) * DEG2RAD );
      double y1 = y2 + ln * Math.sin( (f+a+b+c+d) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[3].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[0].getX(3)-tiles[5].getX(3);
      offsets[3] = tiles[0].getY(3)-tiles[5].getY(3);
   }
}