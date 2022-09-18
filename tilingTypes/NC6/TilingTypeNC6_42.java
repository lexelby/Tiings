package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_42
   extends TilingType
{
   public TilingTypeNC6_42(){
      super( "NC6-42", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{360, 90};
      paramDef = new int[]{150, 60};
      paramName = new String[]{"Angle 1", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 5,0, 1,0,5, 1},
            {1, 0,1, 2,0,1, 0},

            {1, 4,5, 1,3,2, 1},
            {0, 0,1, 4,0,1, 0},
            {0, 5,0, 5,0,5, 0},
            {1, 0,1, 6,0,1, 1},
      };
      info = "a=d=f\nc=e\nC+D=360\n2A+F=360\nD+E=F\n(B+E=A)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double a = getParam(paramValues, 0);
      double c = getParam(paramValues, 1);
      double b = 180-a/2;
      double x = 2*c-a/2;

      double c1 = ln * Math.cos(b*DEG2RAD);
      double s1 = ln * Math.sin(b*DEG2RAD);
      double c2 = Math.cos(c*DEG2RAD);
      double s2 = Math.sin(c*DEG2RAD);
      double c3 = ln * Math.cos(x*DEG2RAD);
      double s3 = ln * Math.sin(x*DEG2RAD);
      
      double ln3 = (2*s1-s3)/2/s2;
      s2 *= ln3;
      c2 *= ln3;
      
      double scale = 2.0 / (c2+c3+c2 + s1+s1);
      s1 *= scale;
      c1 *= scale;
      s2 *= scale;
      c2 *= scale;
      s3 *= scale;
      c3 *= scale;

      double x5 = c1;
      double y5 = s1;
      double x4 = x5 - c1;
      double y4 = y5 + s1;
      double x3 = x4 + c2;
      double y3 = y4 - s2;
      double x2 = x3 + c3;
      double y2 = y3 - s3;
      double x1 = x2 + c2;
      double y1 = y2 - s2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(4);
      offsets[2] = tiles[5].getX(3)-tiles[0].getX(4);
      offsets[3] = tiles[5].getY(3)-tiles[0].getY(4);
   }
}