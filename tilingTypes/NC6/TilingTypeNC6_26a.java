package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_26a
   extends TilingType
{
   public TilingTypeNC6_26a(){
      super( "NC6-26a", 6, SymmetryType.pg );

      paramMin = new int[]{ 72};
      paramMax = new int[]{252};
      paramDef = new int[]{165};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 5,0, 1,1,2, 0},
            {0, 0,1, 2,0,1, 1},
      };
      info = "c=d=e=f=a\nC+E=360\n2A+C=360\n2B+F=360\n(A+D=B)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.4;
      double a = getParam(paramValues, 0);
      double f = 288-a;
      double e = a/2;
      double c = 360-a;
      double d = 180-f/2;
      double b = 720-a-c-d-e-f;

      double x5 = ln * Math.cos( e * DEG2RAD );
      double y5 = ln * Math.sin( e * DEG2RAD );
      double x4 = x5 + ln * Math.cos( (e-180+f) * DEG2RAD );
      double y4 = y5 + ln * Math.sin( (e-180+f) * DEG2RAD );
      double x3 = x4 + ln * Math.cos( (e+f+a) * DEG2RAD );
      double y3 = y4 + ln * Math.sin( (e+f+a) * DEG2RAD );
      double x2 = x3 + ln * Math.cos( (e+f+a-180+b) * DEG2RAD );
      double y2 = y3 + ln * Math.sin( (e+f+a-180+b) * DEG2RAD );
      double x1 = x2 + ln * Math.cos( (e+f+a+b+c) * DEG2RAD );
      double y1 = y2 + ln * Math.sin( (e+f+a+b+c) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(5);
      offsets[2] = tiles[0].getX(4)-tiles[1].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[1].getY(3);
   }
}