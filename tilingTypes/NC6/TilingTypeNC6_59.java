package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_59
   extends TilingType
{
   public TilingTypeNC6_59(){
      super( "NC6-59", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{240,100,100};
      paramDef = new int[]{ 80, 45, 60};
      paramName = new String[]{"Angle", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,0, 0,0,3, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 3,0, 2,0,3, 0},
      };
      info = "b=c=d\na=e\nE+F=360\n2B+C=360\n(A+D=B)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;

      double c = getParam(paramValues, 0);
      double b = 180-c/2;
      double c1 = -ln * Math.cos(b * DEG2RAD);
      double s1 =  ln * Math.sin(b * DEG2RAD);
      double x = getParam(paramValues, 1)/100;
      double y = getParam(paramValues, 2)/100;
      
      double w = ln/2 + (1-2*Math.abs(y-0.5))*c1;
      x = (x-0.5)*2*w;
      y = (y-0.5)*2*s1;
      
      double x1 =  ln;
      double y1 =   0;
      double x2 = x1 + c1;
      double y2 = y1 + s1;
      double x3 = x2 - c1;
      double y3 = y2 + s1;
      double x4 = ln/2 + x;
      double y4 =   s1 + y;
      double x5 = ln/2 - x;
      double y5 =   s1 - y;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[2].getX(3);
      offsets[3] = tiles[0].getY(3)-tiles[2].getY(3);
   }
}